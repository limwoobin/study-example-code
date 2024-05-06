package org.example.section_04.flag;

import java.util.concurrent.atomic.AtomicBoolean;

public class FlagThreadExampleV2 {
    private static AtomicBoolean running = new AtomicBoolean(true);
  public static void main(String[] args) {
    new FlagThreadExampleV2().flagTest();
  }

  private void flagTest() {
    Thread thread = new Thread(() -> {
      int count = 0;
      while (running.get()) {
        count++;
      }

      System.out.println(Thread.currentThread().getName() + " 종료, count: " + count);
    });

    Thread thread2 = new Thread(() -> {
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      running.set(false);
      System.out.println(Thread.currentThread().getName() + " 종료, count");
    });

    thread.start();
    thread2.start();
  }
}
