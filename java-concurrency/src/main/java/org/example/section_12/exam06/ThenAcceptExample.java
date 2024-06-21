package org.example.section_12.exam06;

import java.util.concurrent.CompletableFuture;

public class ThenAcceptExample {
  public static void main(String[] args) {
    MyService service = new MyService();
    CompletableFuture.supplyAsync(() -> {
      System.out.println("thread1: " + Thread.currentThread().getName());
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      return 40;
    }).thenAccept(value -> {
      System.out.println("thread2: " + Thread.currentThread().getName());
      int result = service.getData();
      System.out.println(value + result);
    }).thenAcceptAsync(value -> {
      System.out.println("thread3: " + Thread.currentThread().getName());
      int result = service.getData2();
      System.out.println(value);
      System.out.println(result);
    }).join();
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
