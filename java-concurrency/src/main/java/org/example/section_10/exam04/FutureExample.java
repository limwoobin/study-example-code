package org.example.section_10.exam04;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExample {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(1);
    Future<Integer> future = executorService.submit(() -> {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      return 42;
    });

    try {
      int result = future.get();
      System.out.println("비동기 작업 결과 = " + result);
    } catch (InterruptedException | ExecutionException e) {
      throw new RuntimeException(e);
    }

    executorService.shutdown();
  }
}
