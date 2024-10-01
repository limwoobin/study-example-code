package org.example.step1.section_10.exam03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableExample {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(1);

    Runnable runnableTask = () -> {
      System.out.println(Thread.currentThread().getName() + " Runnable 작업 수행 중..");
      System.out.println(Thread.currentThread().getName() + " Runnable 작업 완료");
    };

    executorService.execute(runnableTask);
    executorService.shutdown();

  }
}
