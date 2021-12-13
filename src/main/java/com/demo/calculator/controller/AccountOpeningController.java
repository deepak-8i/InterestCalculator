package com.demo.calculator.controller;


import com.demo.calculator.service.AccountOpeningService;
import com.demo.calculator.dto.AccountRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class AccountOpeningController {

    @Autowired
    private AccountOpeningService accountOpeningService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/processAccountOpening")
    AccountRequest openAccount(@RequestBody AccountRequest accountDto) {
        return accountOpeningService.save(accountDto);
    }

}
