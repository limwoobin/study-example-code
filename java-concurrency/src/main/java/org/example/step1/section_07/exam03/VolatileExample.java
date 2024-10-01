package org.example.step1.section_07.exam03;

public class VolatileExample {
  volatile boolean running = true;

  public void volatileTest() {
    new Thread(() -> {
      int count = 0;
      while (running) {
        count++;
      }
      System.out.println("Thread 1 종료. Count: " + count);
    }).start();

    new Thread(() -> {
      try {
        Thread.sleep(100);
      } catch (InterruptedException ignored) {
      }
      System.out.println("Thread 2 종료 중..");
      running = false;
    }).start();
  }

  public static void main(String[] args) {
    new VolatileExample().volatileTest();
  }
}
