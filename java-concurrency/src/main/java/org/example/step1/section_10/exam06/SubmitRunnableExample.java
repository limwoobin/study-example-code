package org.example.step1.section_10.exam06;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class SubmitRunnableExample {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    Future<?> future = executorService.submit(() -> {
      System.out.println("비동기 작업 실행중");
    });

    Object result = future.get();
    System.out.println(result);

    Future<Integer> future2 = executorService.submit(() -> {
      System.out.println("비동기 작업 실행중");
    }, 100);

    Object result2 = future2.get();
    System.out.println(result2);

    executorService.shutdown();
  }
}
