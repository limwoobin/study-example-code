package org.example.actuatorstudy.service;

import io.micrometer.core.annotation.Counted;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class OrderServiceV2 {

  @Counted(value = "my.order")
  public void order() {
    log.info("주문");
  }

  @Counted(value = "my.order")
  public void cancel() {
    log.info("취소");
  }
}
