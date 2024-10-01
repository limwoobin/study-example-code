package org.example.step1.section_10.exam03;

import java.time.LocalDateTime;
import java.util.concurrent.*;

public class CallableExampleV2 {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(1);
    Callable<Integer> callableTask = () -> {
      System.out.println("zz: " + LocalDateTime.now());
      Thread.sleep(3000);
      System.out.println("zz: " + LocalDateTime.now());
      System.out.println(Thread.currentThread().getName() + " Callable 작업 완료");
      return 42;
    };

    System.out.println("start");
    System.out.println("ww: " + LocalDateTime.now());
    Future<Integer> future = executorService.submit(callableTask);
    System.out.println("ww: " + LocalDateTime.now());
    System.out.println("get");
    int result = future.get();
    System.out.println("end: " + result);

    executorService.shutdown();
  }
}
