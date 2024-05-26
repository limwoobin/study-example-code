package org.example.section_09.exam01;

import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadCASExample {
  private static AtomicInteger value = new AtomicInteger(0);
  private static int NUM_THREADS = 3;

  public static void main(String[] args) {
    Thread[] threads = new Thread[NUM_THREADS];
    for (int i = 0; i < NUM_THREADS; i++) {
      threads[i] = new Thread(() -> {
        for (int j = 0; j < 100000; j++) {
          int expectedValue;
          int newValue;
          do {
            expectedValue = value.get();
            newValue = expectedValue + 1;
          } while (!value.compareAndSet(expectedValue, newValue));
          System.out.println(Thread.currentThread().getName() + ":" + expectedValue + ":" + newValue);
        }
      });

      threads[i].start();
    }

    for (Thread thread : threads) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    System.out.println("final value: " + value.get());
  }
}
