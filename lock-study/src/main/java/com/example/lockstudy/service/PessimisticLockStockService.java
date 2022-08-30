package com.example.lockstudy.service;

import com.example.lockstudy.domain.Stock;
import com.example.lockstudy.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class PessimisticLockStockService {

    private final StockRepository stockRepository;

    @Transactional
    public void decrease(Long id, Long quantity) {
        Stock stock = stockRepository.findByIdWithinPessimisticLock(id);
        stock.decrease(quantity);

        stockRepository.save(stock);
    }
}
