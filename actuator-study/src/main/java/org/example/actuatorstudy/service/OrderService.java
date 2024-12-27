package org.example.actuatorstudy.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderService {
  private final MeterRegistry registry;

  public OrderService(MeterRegistry registry) {
    this.registry = registry;
  }

  public void order() {
    log.info("주문");

    Counter counter = Counter.builder("my.order")
      .tag("class", this.getClass().getName())
      .tag("method", "order")
      .description("order")
      .register(registry);

    counter.increment();
  }

  public void cancel() {
    log.info("취소");

    Counter counter = Counter.builder("my.order")
      .tag("class", this.getClass().getName())
      .tag("method", "cancel")
      .description("cancel")
      .register(registry);

    counter.increment();
  }
}
