package org.example.section_12.exam09;

import java.util.concurrent.CompletableFuture;

public class ExceptionallyExample {
  public static void main(String[] args) {
    CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> {
      try {
        Thread.sleep(500);
        throw new IllegalArgumentException("error");
      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
      }

      return 10;
    }).thenApply(value -> value + 20)
      .exceptionally(e -> {
        System.out.println("Exception: " + e.getMessage());
        return -1;
    });

    System.out.println("result: " + cf.join());
  }
}
