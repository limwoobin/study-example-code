package org.example.step1.my;

import java.util.concurrent.CompletableFuture;

public class CancelTest {
  public static void main(String[] args) throws InterruptedException {
    CompletableFuture<Integer> cf = CompletableFuture.supplyAsync(() -> {
      throw new IllegalArgumentException("error");
//      return 1;
    });
//    cf.cancel(true);

    Thread.sleep(500);

    System.out.println(cf.isCancelled());
    System.out.println(cf.isCompletedExceptionally());
  }
}
