package org.example.step1.section_10.exam09;

import java.util.concurrent.*;

public class ScheduleCallableExample {
  public static void main(String[] args) {
    ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

    Callable<String> task = () -> {
      return "작업이 한 번 실행되고 결과를 반환";
    };

    ScheduledFuture<String> future = scheduler.schedule(task, 3, TimeUnit.SECONDS);
    try {
      String result = future.get();
      System.out.println("result = " + result);
    } catch (InterruptedException | ExecutionException e) {
      throw new RuntimeException(e);
    }

    scheduler.shutdown();
  }
}
