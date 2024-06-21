package org.example.my;

import java.util.concurrent.CompletableFuture;

public class CompletableFutureTest {
  public static void main(String[] args) throws InterruptedException {
    CompletableFuture.supplyAsync(() -> {
      return "abc";
    }).thenAcceptAsync((value -> {
      String val = value.toUpperCase();
      System.out.println("val: " + val);
    }));

    CompletableFuture.supplyAsync(() -> {
      return "efg";
    }).thenRunAsync(() -> {
      System.out.println("thenRun");
    });

    Thread.sleep(2000);
  }
}
