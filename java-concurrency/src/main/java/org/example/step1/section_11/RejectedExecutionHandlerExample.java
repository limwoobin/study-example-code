package org.example.step1.section_11;

import java.util.concurrent.*;

public class RejectedExecutionHandlerExample {
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
      new MyRejectedExecutionHandler()
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

class MyRejectedExecutionHandler implements RejectedExecutionHandler {

  @Override
  public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
    System.out.println("Task 가 거부되었습니다.");

    if (!executor.isShutdown()) {
      executor.getQueue().poll();
      executor.getQueue().offer(r);
    }
  }
}