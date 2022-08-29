package com.example.lockstudy.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.lockstudy.domain.Stock;
import com.example.lockstudy.repository.StockRepository;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StockServiceTest {

    @Autowired
    private StockService stockService;

    @Autowired
    private StockRepository stockRepository;

    @BeforeEach
    void setUp() {
        Stock stock = new Stock(1L, 100L);
        stockRepository.saveAndFlush(stock);
    }

    @AfterEach
    void teardown() {
        stockRepository.deleteAll();
    }

    @DisplayName("재고 감소 테스트")
    @Test
    void stock_decrease() {
        stockService.decrease(1L, 1L);

        Stock stock = stockRepository.findById(1L).orElseThrow();
        assertEquals(99, stock.getQuantity());
    }

    @Test
    public void 동시에_100개_요청() {
        int numberOfThreads = 100;
        ExecutorService executorService = Executors.newFixedThreadPool(32);
        CountDownLatch latch = new CountDownLatch(numberOfThreads);

        for (int i=0; i<numberOfThreads; i++) {
            executorService.submit(() -> {
                stockService.decrease(1L, 1L);
                latch.countDown();
            });
        }

        latch.countDown();

        Stock stock = stockRepository.findById(1L).orElseThrow();
        System.out.println(stock.getQuantity());

        assertEquals(0L, stock.getQuantity());
    }
}
