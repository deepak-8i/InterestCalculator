package com.demo.calculator.controller;

import com.demo.calculator.dto.AccountMonthlyInterestDto;
import com.demo.calculator.service.AccountMonthlyInterestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class AccountMonthlyInterestController {

    @Autowired
    private AccountMonthlyInterestService accountMonthlyInterestService;

    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/calculateMonthlyInterest")
    public List<AccountMonthlyInterestDto> calculateMonthlyInterest() {
        return accountMonthlyInterestService.calculateMonthlyInterest();
    }
}
