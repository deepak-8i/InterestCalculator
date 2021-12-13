package com.demo.calculator.service;

import com.demo.calculator.dto.AccountRequest;

public interface AccountOpeningService {

    AccountRequest save(AccountRequest accountDto);
}
