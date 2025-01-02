package org.example.actuatorstudy.service.guage;

import io.micrometer.core.instrument.Gauge;
import io.micrometer.core.instrument.MeterRegistry;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.example.actuatorstudy.service.OrderService;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class StockConfigV1 {

  static class MyStockService {
    private OrderService orderService;
    private MeterRegistry registry;

    public MyStockService(OrderService orderService, MeterRegistry registry) {
      this.orderService = orderService;
      this.registry = registry;
    }

    @PostConstruct
    public void init() {
      Gauge.builder("my.stock", orderService, service -> {
        log.info("stock gauge called");
        return 1; // 재고
      }).register(registry);
    }
  }
}
