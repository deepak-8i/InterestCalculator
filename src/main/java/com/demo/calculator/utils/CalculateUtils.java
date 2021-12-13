package com.demo.calculator.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

public class CalculateUtils {

    public static BigDecimal calculateDailyInterest(double dailyInterestRate, BigDecimal balance, Date dayEndDate) {
        LocalDate date = LocalDate.ofInstant(dayEndDate.toInstant(), ZoneId.systemDefault());
        return balance.multiply(BigDecimal.valueOf(dailyInterestRate/(100.0*date.lengthOfYear())));
    }
}
