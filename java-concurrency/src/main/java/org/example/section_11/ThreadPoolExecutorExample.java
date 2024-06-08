package org.example.section_11;

import java.util.concurrent.*;

public class ThreadPoolExecutorExample {
  public static void main(String[] args) {
    int corePoolSize = 2;
    int maxPoolSize = 4;
    long keepAliveTime = 0L; // 유휴시간, 시간이 지나면 maxPoolSize 는 corePoolSize 만큼 제거됨
    BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>();
//    BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(4);

    int taskNum = 9;

    ThreadPoolExecutor executor = new ThreadPoolExecutor(
      corePoolSize,
      maxPoolSize,
      keepAliveTime,
      TimeUnit.SECONDS,
      workQueue
    );

    for (int i = 0; i < taskNum; i++) {
      final int taskId = i;
      executor.execute(() -> {
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName() + " 가 태스크" + taskId + "를 실행하고 있습니다.");
      });
    }

    executor.shutdown();
  }
}
