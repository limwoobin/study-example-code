package org.example.section_09.exam01;

public class NonAtomicExample {
  private static int value = 0;
  private static int NUM_THREADS = 3;

  public static void main(String[] args) {
    Thread[] threads = new Thread[NUM_THREADS];
    for (int i = 0; i < NUM_THREADS; i++) {
      threads[i] = new Thread(() -> {
        for (int j = 0; j < 10000; j++) {
          int expectedValue = value;
          int newValue = expectedValue + 1;
          value = newValue;
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

    System.out.println("final value: " + value);
  }
}
