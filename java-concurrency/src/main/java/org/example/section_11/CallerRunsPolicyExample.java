package org.example.section_11;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CallerRunsPolicyExample {
  public static void main(String[] args) {
    int corePoolSize = 2;
    int maxPoolSize = 2;
    long keepAliveTime = 0L;
    BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);

    ThreadPoolExecutor executor = new ThreadPoolExecutor(
      corePoolSize,
      maxPoolSize,
      keepAliveTime,
      TimeUnit.SECONDS,
      workQueue,
      new ThreadPoolExecutor.CallerRunsPolicy()
    );

    submitTasks(executor);
  }

  private static void submitTasks(ThreadPoolExecutor executor) {
    for (int i = 1; i <= 5; i++) {
      final int taskId = i;
      executor.submit(() -> {
        System.out.println("Task " + taskId + " is running on thread " + Thread.currentThread().getName());
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
      });
    }
    executor.shutdown();
  }
}
