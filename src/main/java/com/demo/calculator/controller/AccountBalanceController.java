package com.demo.calculator.controller;

import com.demo.calculator.dto.EndOfDayBalanceRequest;
import com.demo.calculator.service.AccountBalanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class AccountBalanceController {

    @Autowired
    private AccountBalanceService accountBalanceService;

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping("/processAccountEndOfDayBalances")
    ResponseEntity<Object> calculateEndOfDayBalances(@RequestBody EndOfDayBalanceRequest endOfDayBalanceRequest) {
        accountBalanceService.calculateEODBalances(endOfDayBalanceRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
