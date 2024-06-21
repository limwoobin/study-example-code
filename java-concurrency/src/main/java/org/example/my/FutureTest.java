package org.example.my;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureTest {
  public static void main(String[] args) throws Exception {
    ExecutorService executorService = Executors.newFixedThreadPool(1);
    Callable<String> callable = () -> {
      System.out.println("Callable 123");
      return "123";
    };

    Future<String> future = executorService.submit(callable);

    executorService.shutdown();
    Thread.sleep(3000);
  }
}
