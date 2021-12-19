package com.demo.calculator.service;

import com.demo.calculator.dto.AccountMonthlyInterestDto;

import java.util.List;

public interface AccountMonthlyInterestService {
    List<AccountMonthlyInterestDto> calculateMonthlyInterest();
}
