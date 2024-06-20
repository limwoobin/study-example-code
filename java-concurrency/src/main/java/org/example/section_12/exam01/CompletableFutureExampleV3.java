package org.example.section_12.exam01;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExampleV3 {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    System.out.println(1);
    System.out.println(2);

    CompletableFuture.runAsync(() -> {
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      })
      .thenRunAsync(() -> System.out.println("end..."));

    System.out.println(3);
    System.out.println(4);
    System.out.println(5);

    Thread.sleep(1000);
  }
}
