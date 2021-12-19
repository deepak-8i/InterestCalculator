package com.demo.calculator.service;

import com.demo.calculator.dao.AccountRepository;
import com.demo.calculator.model.Account;
import com.demo.calculator.utils.ConverterUtils;
import com.demo.calculator.dto.AccountDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountOpeningServiceImpl implements AccountOpeningService {

    @Autowired
    private AccountRepository accountRepository;

    @Override
    public AccountDto save(AccountDto accountDto) {
      Account account =  accountRepository.save(ConverterUtils.convertToAccount(accountDto));
      return ConverterUtils.convertToAccountDto(account);
    }
}
