package com.demo.calculator.dao;

import com.demo.calculator.model.AccountBalanceId;
import com.demo.calculator.model.AccountEndDayBalance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountEndDayBalanceRepository extends JpaRepository<AccountEndDayBalance, AccountBalanceId> {

}
