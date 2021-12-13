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
@Table(name = "account_monthly_interest")
public class AccountMonthlyInterest {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "account_number", nullable = false )
    private Long accountNumber;

    @Column(name = "monthly_interest_balance", nullable = false)
    private BigDecimal balance;

    @Column(name = "month_end_date", nullable = false)
    private Date dayEndDate;

}
