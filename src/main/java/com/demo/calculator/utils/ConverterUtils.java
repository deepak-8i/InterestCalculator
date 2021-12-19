package com.demo.calculator.utils;

import com.demo.calculator.dto.AccountEndDayBalanceDto;
import com.demo.calculator.dto.AccountMonthlyInterestDto;
import com.demo.calculator.dto.EndOfDayBalanceDto;
import com.demo.calculator.model.Account;
import com.demo.calculator.dto.AccountDto;
import com.demo.calculator.model.AccountEndDayBalance;
import com.demo.calculator.model.AccountMonthlyInterest;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConverterUtils {

    public static Account convertToAccount(AccountDto accountDto){
        return Account.builder()
                .accountNumber(accountDto.getAccountNumber())
                .bsb(accountDto.getBsb())
                .accountOpenDate(accountDto.getAccountOpenDate()).build();
    }

    public static AccountDto convertToAccountDto(Account account){
        return AccountDto.builder()
                .accountNumber(account.getAccountNumber())
                .bsb(account.getBsb())
                .accountOpenDate(account.getAccountOpenDate()).build();
    }

    public static List<AccountEndDayBalance> convertToAccountEndBalances(EndOfDayBalanceDto endOfDayBalanceRequest) {

        List<AccountEndDayBalance> accountEndDayBalances = new ArrayList<>();
        for (AccountEndDayBalanceDto accountEndDayBalanceDto: endOfDayBalanceRequest.getAccountEndDayBalances()) {
            accountEndDayBalances.add(convertToAccountEndDayBalance(accountEndDayBalanceDto, endOfDayBalanceRequest.getDayEndDate()));
        }
        return accountEndDayBalances;
    }

    public static AccountEndDayBalance convertToAccountEndDayBalance(AccountEndDayBalanceDto accountEndDayBalanceDto, Date endOfDayDate){

        return AccountEndDayBalance.builder()
                .accountNumber(accountEndDayBalanceDto.getAccountNumber())
                .balance(accountEndDayBalanceDto.getBalance())
                .dayEndDate(endOfDayDate).build();
    }

    public static AccountMonthlyInterestDto convertToAccountMonthlyInterest(AccountMonthlyInterest accountMonthlyInterest) {
        return AccountMonthlyInterestDto.builder()
                .accountNumber(accountMonthlyInterest.getAccountNumber())
                .balance(accountMonthlyInterest.getBalance())
                .dayEndDate(accountMonthlyInterest.getDayEndDate()).build();
    }
}
