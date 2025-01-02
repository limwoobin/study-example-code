package org.example.actuatorstudy.service;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;

@Slf4j
@Service
@Timed(value = "my.order")
public class OrderServiceV4 {

  public void order() {
    log.info("주문");
    sleep(500);
  }

  public void cancel() {
    log.info("취소");
    sleep(500);
  }

  static void sleep(int l) {
    try {
      Thread.sleep(l + new Random().nextInt(200));
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
