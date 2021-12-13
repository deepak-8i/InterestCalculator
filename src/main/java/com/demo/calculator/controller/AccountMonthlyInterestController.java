package com.demo.calculator.controller;

import com.demo.calculator.service.AccountMonthlyInterestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AccountMonthlyInterestController {

    //@Autowired
    private AccountMonthlyInterestService accountMonthlyInterestService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/calculateMonthlyInterest")
    void calculateMonthlyInterest() {
         accountMonthlyInterestService.calculateMonthlyInterest();
    }
}
