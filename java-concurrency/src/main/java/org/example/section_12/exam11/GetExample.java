package org.example.section_12.exam11;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class GetExample {
  public static void main(String[] args) {
    CompletableFuture<Integer> cf1 = CompletableFuture.supplyAsync(() -> {
      throw new IllegalArgumentException("error");
    });

    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    try {
      Integer result = cf1.get();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } catch (ExecutionException e) {
      throw new RuntimeException(e);
    }
  }
}
