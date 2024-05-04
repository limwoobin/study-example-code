package com.example.springconfig;

import com.example.springconfig.config.Exam;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

class ExamTest {

  @RepeatedTest(value = 5)
  @Test
  void default_test() {
    Exam exam = new Exam();
    System.out.println("exam: " + exam);
  }
}
