package com.demo.calculator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AccountBalanceId implements Serializable {

    @Column(name = "account_number", nullable = false )
    private Long accountNumber;

    @Column(name = "day_end_date", nullable = false)
    private Date dayEndDate;
}
