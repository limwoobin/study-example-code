package org.example.section_04.thread_local;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolThreadLocalExample {
  private static ThreadLocal<String> threadLocal = new ThreadLocal<>();

  public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(2);
    executor.submit(() -> {
      threadLocal.set("작업 1의 값");
      System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
      threadLocal.remove();
    });

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    for (int i = 0; i < 5; i++) {
      executor.submit(() -> {
        System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
      });
    }

    executor.shutdown();
  }
}
