package org.example.section_10.exam04;

import java.util.concurrent.*;

public class FutureCallbackExample {

  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(1);

    Callable<Integer> callableTask = () -> {
      Thread.sleep(1000);
      return 42;
    };

    Future<Integer> future = executorService.submit(callableTask);
    System.out.println("비동기 작업 시작");

    registerCallback(future, result -> System.out.println("비동기 작업 결과:" + result));
    executorService.shutdown();
  }

  private static void registerCallback(Future<Integer> future, Callback callback) {
    new Thread(() -> {
      int result;
      try {
        result = future.get();
      } catch (InterruptedException | ExecutionException e) {
        throw new RuntimeException(e);
      }

      callback.onComplete(result);
    }).start();
  }
}

@FunctionalInterface
interface Callback {
  void onComplete(int result);
}