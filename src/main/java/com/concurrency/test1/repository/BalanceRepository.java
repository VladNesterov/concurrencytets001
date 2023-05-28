package com.concurrency.test1.repository;

import com.concurrency.test1.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceRepository extends JpaRepository<Balance, Long> {


    @Modifying
    @Query("update Balance b set b.amount = :amount where b.id = :id")
    void updateAmountById(@Param(value = "id") long id, @Param(value = "amount") Long amount);
}
