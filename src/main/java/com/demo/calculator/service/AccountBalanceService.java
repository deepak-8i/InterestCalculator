package com.demo.calculator.service;

import com.demo.calculator.dto.EndOfDayBalanceDto;

public interface AccountBalanceService {

    void calculateEODBalances(EndOfDayBalanceDto endOfDayBalanceRequest);
}
