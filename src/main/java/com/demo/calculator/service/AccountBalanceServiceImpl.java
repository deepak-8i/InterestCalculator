package com.demo.calculator.service;

import com.demo.calculator.dao.AccountEndDayBalanceRepository;
import com.demo.calculator.dto.EndOfDayBalanceDto;
import com.demo.calculator.model.AccountEndDayBalance;
import com.demo.calculator.utils.CalculateUtils;
import com.demo.calculator.utils.ConverterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountBalanceServiceImpl implements AccountBalanceService {

    @Autowired
    private AccountEndDayBalanceRepository accountEndDayBalanceRepository;

    private static double DAILY_INTEREST_RATE = 5.0;

    @Override
    public void calculateEODBalances(EndOfDayBalanceDto endOfDayBalanceRequest) {

        List<AccountEndDayBalance> accountEndDayBalances = ConverterUtils.convertToAccountEndBalances(endOfDayBalanceRequest);
        calculateInterest(accountEndDayBalances);
        accountEndDayBalanceRepository.saveAll(accountEndDayBalances);
    }

    private void calculateInterest(List<AccountEndDayBalance> accountEndDayBalances) {

        for (AccountEndDayBalance accountEndDayBalance: accountEndDayBalances) {
            accountEndDayBalance.setDailyInterest(
                    CalculateUtils.calculateDailyInterest(DAILY_INTEREST_RATE,
                            accountEndDayBalance.getBalance(), accountEndDayBalance.getDayEndDate()));
        }
    }
}
