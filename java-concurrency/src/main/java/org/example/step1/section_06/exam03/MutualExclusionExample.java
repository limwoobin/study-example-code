package org.example.step1.section_06.exam03;

public class MutualExclusionExample {
  private int counter = 0;

  public synchronized void increment() {
    counter++;
    System.out.println("스레드: " + Thread.currentThread().getName() + " 카운터: " + counter);
  }

  public static void main(String[] args) {
    MutualExclusionExample example = new MutualExclusionExample();

    Thread thread = new Thread(() -> {
      for (int i = 0; i < 500000; i++) {
        example.increment();
      }
    });

    Thread thread2 = new Thread(() -> {
      for (int i = 0; i < 500000; i++) {
        example.increment();
      }
    });

    thread.start();
    thread2.start();
  }
}
