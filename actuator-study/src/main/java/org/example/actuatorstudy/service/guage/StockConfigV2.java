package org.example.actuatorstudy.service.guage;

import io.micrometer.core.instrument.binder.MeterBinder;
import io.prometheus.metrics.core.metrics.Gauge;
import lombok.extern.slf4j.Slf4j;
import org.example.actuatorstudy.service.OrderService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class StockConfigV2 {

//  @Bean
//  public MeterBinder stockSize(OrderService orderService) {
//    return registry -> Gauge.builder("my.stock", orderService, service -> {
//      log.info("stock gauge called");
//      return 1;
//    }).register(registry);
//  }
}
