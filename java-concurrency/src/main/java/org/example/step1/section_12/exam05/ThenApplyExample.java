package org.example.step1.section_12.exam05;

import java.util.concurrent.CompletableFuture;

public class ThenApplyExample {
  public static void main(String[] args) {
    MyService service = new MyService();
    long start = System.currentTimeMillis();

    CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> {
      System.out.println("thread1: " + Thread.currentThread().getName());
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      return 40;
    }).thenApplyAsync(value -> {
      System.out.println("thread2: " + Thread.currentThread().getName());
      int result = service.getData();
      return value + result;
    }).thenApplyAsync(value -> {
      System.out.println("thread3: " + Thread.currentThread().getName());
      int result = service.getData2();
      return value + result;
    });

    int finalResult = cf.join();
    System.out.println("소요 시간: " + (System.currentTimeMillis() - start));
    System.out.println("finalResult = " + finalResult);
  }

  static class MyService {
    public int getData() {
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      return 50;
    }

    public int getData2() {
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      return 50;
    }
  }
}
