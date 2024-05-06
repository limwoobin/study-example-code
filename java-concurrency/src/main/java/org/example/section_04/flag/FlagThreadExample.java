package org.example.section_04.flag;


public class FlagThreadExample {
  private volatile static boolean running = true;
  public static void main(String[] args) {
    Thread thread = new Thread(() -> {
      int count = 0;
      while (running) {
        count++;
      }

      System.out.println(Thread.currentThread().getName() + " 종료, count: " + count);
    });

    Thread thread2 = new Thread(() -> {
      try {
        Thread.sleep(500);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      System.out.println(Thread.currentThread().getName() + " 종료");
      running = false;
    });

    thread.start();
    thread2.start();
  }
}
