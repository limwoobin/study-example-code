package com.example.lockstudy.repository;

import com.example.lockstudy.domain.Stock;
import javax.persistence.LockModeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;

public interface StockRepository extends JpaRepository<Stock, Long> {

    @Lock(value = LockModeType.PESSIMISTIC_WRITE)
    @Query("select  s from Stock s where s.id = :id")
    Stock findByIdWithinPessimisticLock(Long id);

    @Lock(value = LockModeType.OPTIMISTIC)
    @Query("select  s from Stock s where s.id = :id")
    Stock findByIdWithOptimisticLock(Long id);
}
