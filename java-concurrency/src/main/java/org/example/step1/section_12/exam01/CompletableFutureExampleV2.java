package org.example.step1.section_12.exam01;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExampleV2 {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    CompletableFuture<Integer> supplyFuture = CompletableFuture.supplyAsync(() -> {
      System.out.println("Supply Async");
      return 1;
    });

    System.out.println(supplyFuture.get());


    CompletableFuture<Void> runFuture = CompletableFuture.runAsync(() -> {
      System.out.println("Run Async");
    });

    Object a = runFuture.get();
    System.out.println(a);
  }
}
