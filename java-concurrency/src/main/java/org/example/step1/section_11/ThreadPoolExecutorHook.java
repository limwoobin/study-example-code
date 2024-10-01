package org.example.step1.section_11;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorHook extends ThreadPoolExecutor {

  public ThreadPoolExecutorHook(int corePoolSize, int maximumPoolSize, long keepAliveTime, TimeUnit unit, BlockingQueue<Runnable> workQueue) {
    super(corePoolSize, maximumPoolSize, keepAliveTime, unit, workQueue);
  }

  public static void main(String[] args) {
    int corePoolSize = 2;
    int maxPoolSize = 4;
    long keepAliveTime = 0L;
    BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);

    ThreadPoolExecutorHook executor = new ThreadPoolExecutorHook(
      corePoolSize,
      maxPoolSize,
      keepAliveTime,
      TimeUnit.SECONDS,
      workQueue
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

  @Override
  protected void beforeExecute(Thread t, Runnable r) {
    System.out.println(t.getName() + " 가 작업을 실행하려고 합니다.");
    super.beforeExecute(t, r);
  }

  @Override
  protected void afterExecute(Runnable r, Throwable t) {
    if (t != null) {
      System.out.println("작업이 "+ t.getMessage() + " 예외가 발생했습니다.");
    } else {
      System.out.println("작업이 성공적으로 완료했습니다.");
    }
    super.afterExecute(r, t);
  }

  @Override
  protected void terminated() {
    System.out.println("스레드 풀이 종료되었습니다.");
    super.terminated();
  }
}
