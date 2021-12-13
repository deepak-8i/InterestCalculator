package com.demo.calculator.service;

import com.demo.calculator.dto.EndOfDayBalanceRequest;

public interface AccountBalanceService {

    void calculateEODBalances(EndOfDayBalanceRequest endOfDayBalanceRequest);
}
