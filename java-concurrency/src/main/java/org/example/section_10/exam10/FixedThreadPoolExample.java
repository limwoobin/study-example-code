package org.example.section_10.exam10;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolExample {
  public static void main(String[] args) throws InterruptedException {
    Map<Thread, StackTraceElement[]> allThreads = Thread.getAllStackTraces();
    int threadCount = allThreads.size();
    System.out.println(threadCount);

    ExecutorService executorService = Executors.newFixedThreadPool(3);

    for (int i = 0; i < 5; i++) {
      executorService.submit(() -> {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }

        System.out.println("Thread: " + Thread.currentThread().getName());
      });
    }

    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    Map<Thread, StackTraceElement[]> allThreads2 = Thread.getAllStackTraces();
    int threadCount2 = allThreads2.size();
    System.out.println(threadCount2);

    executorService.shutdown();

    Thread.sleep(2000);

    if (executorService.isShutdown()) {
      System.out.println("shut true");
    }

    if (executorService.isTerminated()) {
      System.out.println("ter true");
    }

    Map<Thread, StackTraceElement[]> allThreads3 = Thread.getAllStackTraces();
    int threadCount3 = allThreads3.size();
    System.out.println(threadCount3);
  }
}
