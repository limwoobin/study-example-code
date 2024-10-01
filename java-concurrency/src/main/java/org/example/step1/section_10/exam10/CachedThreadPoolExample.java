package org.example.step1.section_10.exam10;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPoolExample {
  public static void main(String[] args) {
    ExecutorService executorService = Executors.newCachedThreadPool();
    for (int i = 0; i < 20; i++) {
      executorService.submit(() -> {
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }

        System.out.println("Thread: " + Thread.currentThread().getName());
      });
    }


    executorService.shutdown();
  }
}
