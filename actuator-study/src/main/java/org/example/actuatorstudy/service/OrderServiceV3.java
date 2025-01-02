package org.example.actuatorstudy.service;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
public class OrderServiceV3 {
  private final MeterRegistry registry;

  public OrderServiceV3(MeterRegistry registry) {
    this.registry = registry;
  }

  public void order() {
    Timer timer = Timer.builder("my.order")
      .tag("class", this.getClass().getName())
      .tag("method", "order")
      .description("order")
      .register(registry);

    timer.record(() -> {
      log.info("주문");
      sleep(500);
    });
  }

  public void cancel() {
    Timer timer = Timer.builder("my.order")
      .tag("class", this.getClass().getName())
      .tag("method", "cancel")
      .description("cancel")
      .register(registry);

    timer.record(() -> {
      log.info("취소");
      sleep(500);
    });
  }

  static void sleep(int l) {
    try {
      Thread.sleep(l + new Random().nextInt(200));
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
