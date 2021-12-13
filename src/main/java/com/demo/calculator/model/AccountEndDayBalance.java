package com.demo.calculator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "account_day_end_balance")
@IdClass(AccountBalanceId.class)
public class AccountEndDayBalance {

    @Id
    @Column(name = "account_number", nullable = false )
    private Long accountNumber;

    @Id
    @Column(name = "day_end_date", nullable = false)
    private Date dayEndDate;

    @Column(name = "balance", nullable = false)
    private BigDecimal balance;

    @Column(name = "daily_interest", nullable = false)
    private BigDecimal dailyInterest;

}
