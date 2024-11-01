package org.example.step1.my;

import java.util.concurrent.CompletableFuture;

public class CancelTest {
  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(() -> {
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      System.out.println("Thread");
    });

    System.out.println("Main Thread Start");
    thread.start();
    System.out.println("Main Thread End");
  }
}
