package org.example.section_10.exam05;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureCancelExample {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newSingleThreadExecutor();

    // Callable 작업 생성
    Callable<Integer> callableTask = () -> {
      System.out.println("비동기 작업 시작...");
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("비동기 작업 완료.");
      return 42;
    };

    // 작업을 제출 하고 Future 객체를 받음
    Future<Integer> future = executorService.submit(callableTask);
    boolean cancel = future.cancel(true);

    try {
      Integer result = future.get();
      System.out.println("Result: " + result);
    } catch (Exception e) {
      e.printStackTrace();
    }

    executorService.shutdown();
  }
}
