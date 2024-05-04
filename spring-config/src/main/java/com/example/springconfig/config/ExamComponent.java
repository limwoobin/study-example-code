package com.example.springconfig.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ExamComponent {

  @Bean
  public Exam2 exam2() {
    return new Exam2();
  }
}
