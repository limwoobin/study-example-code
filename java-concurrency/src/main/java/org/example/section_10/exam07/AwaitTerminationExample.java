package org.example.section_10.exam07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

public class AwaitTerminationExample {
  public static void main(String[] args) throws InterruptedException {
    ExecutorService executorService = Executors.newFixedThreadPool(2, new ThreadFactory() {
      @Override
      public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setDaemon(true);
        return thread;
      }
    });

    executorService.submit(() -> {
      while (true) {
        System.out.println(Thread.currentThread().getName() + " Daemon Thread Running...");
        Thread.sleep(1000);
      }
    });

    executorService.shutdown();

//    try {
//      executorService.awaitTermination(5, TimeUnit.SECONDS);
//    } catch (InterruptedException e) {
//      throw new RuntimeException(e);
//    }

    Thread.sleep(3000);
    System.out.println("메인 스레드 종료");
  }
}
