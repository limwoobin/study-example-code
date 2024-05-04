package com.example.springconfig;

import com.example.springconfig.config.Exam;
import com.example.springconfig.config.Exam2;
import com.example.springconfig.config.ExamComponent;
import com.example.springconfig.config.ExamConfiguration;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootTest
public class ExamTest2 {

  @Autowired
  private ExamConfiguration examConfiguration;

  @Autowired
  private ExamComponent examComponent;

  @Autowired
  private ApplicationContext applicationContext;

  @RepeatedTest(value = 5)
  @Test
  void configuration_test() {
    Exam exam = examConfiguration.exam();
    System.out.println("exam: " + exam);
  }

  @RepeatedTest(value = 5)
  void component_test() {
    Exam2 exam2 = examComponent.exam2();
    System.out.println("exam2: " + exam2);
  }

  @Test
  void test() {
    Exam exam = examConfiguration.exam();
    Exam2 exam2 = examComponent.exam2();

    System.out.println(exam);
    System.out.println(exam2);
  }

  @Test
  void test2() {
    ApplicationContext ac = new AnnotationConfigApplicationContext(ExamConfiguration.class);
    ApplicationContext ac2 = new AnnotationConfigApplicationContext(ExamComponent.class);

    Object o = ac.getBean("exam");
    Object o2 = ac2.getBean("exam2");

    System.out.println(o);
    System.out.println(o2);

    Object result = applicationContext.getBean("exam");
    Object result2 = applicationContext.getBean("exam2");

    System.out.println(result);
    System.out.println(result2);

//    boolean result = applicationContext.containsBean("exam");
//    boolean result2 = applicationContext.containsBean("exam2");
//
//    System.out.println(result);
//    System.out.println(result2);
  }
}
