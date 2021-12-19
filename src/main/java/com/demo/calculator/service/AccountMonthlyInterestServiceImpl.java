package com.demo.calculator.service;

import com.demo.calculator.dao.AccountEndDayBalanceRepository;
import com.demo.calculator.dao.AccountMonthlyInterestRepository;
import com.demo.calculator.dto.AccountMonthlyInterestDto;
import com.demo.calculator.model.AccountEndDayBalance;
import com.demo.calculator.model.AccountMonthlyInterest;
import com.demo.calculator.utils.ConverterUtils;
import com.demo.calculator.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;
import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;

@Service
public class AccountMonthlyInterestServiceImpl implements AccountMonthlyInterestService {

    @Autowired
    private AccountEndDayBalanceRepository accountEndDayBalanceRepository;

    @Autowired
    private AccountMonthlyInterestRepository accountMonthlyInterestRepository;

    @Override
    public List<AccountMonthlyInterestDto> calculateMonthlyInterest() {

        LocalDate initial = LocalDate.now();
        LocalDate start = initial.with(firstDayOfMonth());
        LocalDate end = initial.with(lastDayOfMonth());
        List<AccountEndDayBalance> accountEODBalances =  accountEndDayBalanceRepository.getAllBetweenDates(DateUtils.asDate(start),DateUtils.asDate(end));

        List<AccountMonthlyInterest> accountMonthlyInterests = new ArrayList<>();

        accountEODBalances.stream().collect(
                Collectors.groupingBy(AccountEndDayBalance::getAccountNumber,
                        Collectors.mapping(AccountEndDayBalance::getDailyInterest, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))))
                .forEach((k,v) -> accountMonthlyInterests.add(new AccountMonthlyInterest(k,v,DateUtils.asDate(end))));

        List<AccountMonthlyInterestDto> accountMonthlyInterestDtos= new ArrayList<>();
        for (AccountMonthlyInterest accountMonthlyInterest: accountMonthlyInterests) {
            accountMonthlyInterestRepository.save(accountMonthlyInterest);
            accountMonthlyInterestDtos.add(ConverterUtils.convertToAccountMonthlyInterest(accountMonthlyInterest));
        }
        return accountMonthlyInterestDtos;
    }
}
