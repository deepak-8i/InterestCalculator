package com.demo.calculator.dao;

import com.demo.calculator.model.AccountBalanceId;
import com.demo.calculator.model.AccountEndDayBalance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AccountEndDayBalanceRepository extends JpaRepository<AccountEndDayBalance, AccountBalanceId> {

    @Query(value = "from AccountEndDayBalance t where dayEndDate BETWEEN :startDate AND :endDate")
    public List<AccountEndDayBalance> getAllBetweenDates(@Param("startDate") Date startDate, @Param("endDate")Date endDate);
}
