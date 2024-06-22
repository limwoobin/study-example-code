package org.example.section_12.exam10;

import java.util.concurrent.CompletableFuture;

public class CompletedFutureExample {
  public static void main(String[] args) {
    CompletableFuture<String> cf = CompletableFuture.completedFuture("Hello World");
    CompletableFuture<Void> finalCf = cf.thenAccept(value -> {
      System.out.println("value = " + value);
    });
  }
}
