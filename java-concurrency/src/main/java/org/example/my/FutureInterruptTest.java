package org.example.my;

import java.util.concurrent.*;

public class FutureInterruptTest {
  public static void main(String[] args) {
    CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
      return "5";
    });

    Thread thread = new Thread(() -> {
      String value = null;
      try {
        value = future.get(2, TimeUnit.SECONDS);
      } catch (InterruptedException | ExecutionException | TimeoutException e) {
        System.out.println("Thread1 Exception");
        throw new RuntimeException(e);
      }

      System.out.println(Thread.currentThread().getName() + ", " + value);
    });

    Thread thread2 = new Thread(() -> {
      String value = null;
      try {
        Thread.sleep(1000);
//        future.cancel(true);
        thread.interrupt();
      } catch (Exception e) {
        System.out.println("Thread2 Exception");
        throw new RuntimeException(e);
      }
    });

    thread.start();
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    thread2.start();
  }
}
