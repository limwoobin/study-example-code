package org.example.section_10.exam06;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitCallableExample {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newSingleThreadExecutor();
    Future<String> future = executorService.submit(() -> {
      System.out.println("비동기 작업 실행");
      return "Hello world";
    });

    try {
      String result = future.get();
      System.out.println(result);
    } catch (InterruptedException | ExecutionException e) {
      throw new RuntimeException(e);
    }

    executorService.shutdown();
  }
}
