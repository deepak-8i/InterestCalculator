package com.demo.calculator.model;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "Account")
public class Account {

    @Id
    @Column(name = "account_number", nullable = false )
    private long accountNumber;

    @Column(name = "bsb", nullable = false)
    private String bsb;

    @Column(name = "account_open_date", nullable = false)
    private Date accountOpenDate;
}
