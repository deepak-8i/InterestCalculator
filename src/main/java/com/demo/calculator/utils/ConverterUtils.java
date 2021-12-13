package com.demo.calculator.utils;

import com.demo.calculator.dto.AccountEndDayBalanceRequest;
import com.demo.calculator.dto.EndOfDayBalanceRequest;
import com.demo.calculator.model.Account;
import com.demo.calculator.dto.AccountRequest;
import com.demo.calculator.model.AccountEndDayBalance;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConverterUtils {

    public static Account convertToAccount(AccountRequest accountDto){
        return Account.builder()
                .accountNumber(accountDto.getAccountNumber())
                .bsb(accountDto.getBsb())
                .accountOpenDate(accountDto.getAccountOpenDate()).build();
    }

    public static AccountRequest convertToAccountDto(Account account){
        return AccountRequest.builder()
                .accountNumber(account.getAccountNumber())
                .bsb(account.getBsb())
                .accountOpenDate(account.getAccountOpenDate()).build();
    }

    public static List<AccountEndDayBalance> convertToAccountEndBalances(EndOfDayBalanceRequest endOfDayBalanceRequest) {

        List<AccountEndDayBalance> accountEndDayBalances = new ArrayList<>();
        for (AccountEndDayBalanceRequest accountEndDayBalanceDto: endOfDayBalanceRequest.getAccountEndDayBalances()) {
            accountEndDayBalances.add(convertToAccountEndDayBalance(accountEndDayBalanceDto, endOfDayBalanceRequest.getDayEndDate()));
        }
        return accountEndDayBalances;
    }

    public static AccountEndDayBalance convertToAccountEndDayBalance(AccountEndDayBalanceRequest accountEndDayBalanceDto, Date endOfDayDate){

        return AccountEndDayBalance.builder()
                .accountNumber(accountEndDayBalanceDto.getAccountNumber())
                .balance(accountEndDayBalanceDto.getBalance())
                .dayEndDate(endOfDayDate).build();
    }
}
