package org.example.step1.section_10.exam03;

import java.util.concurrent.*;

public class CallableExample {
  public static void main(String[] args) throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(1);
    Callable<Integer> callableTask = () -> {
      System.out.println(Thread.currentThread().getName() + " Callable 작업 수행중..");
      System.out.println(Thread.currentThread().getName() + " Callable 작업 완료");
      return 42;
    };

    Future<Integer> future = executorService.submit(callableTask);
    Thread.sleep(3000);
    int result;
    try {
      result = future.get();
    } catch (InterruptedException | ExecutionException e) {
      throw new RuntimeException(e);
    }

    System.out.println("result: " + result);
    executorService.shutdown();
  }
}
