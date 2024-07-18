package org.example.my;

import org.example.section_10.exam10.FixedThreadPoolExample;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolTest2 {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newFixedThreadPool(3);
    ForkJoinPool forkJoinPool = new ForkJoinPool(4);

    CompletableFuture.runAsync(() -> System.out.println("Default: " + Thread.currentThread().getName()));
    CompletableFuture.runAsync(() -> System.out.println("Executor: " + Thread.currentThread().getName()), executorService);
    CompletableFuture.runAsync(() -> System.out.println("ForkJoinPool: " + Thread.currentThread().getName()), forkJoinPool);

    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    executorService.shutdown();
    forkJoinPool.shutdown();
  }
}
