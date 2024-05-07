package org.example.section_05.exam02;

public class CpuNonSyncExample {
  private static int count = 0;
  private static final int ITERATIONS = 100000;

  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(() -> {
      for (int i = 0; i < ITERATIONS; i++) {
        count++;
      }
    });

    Thread thread2 = new Thread(() -> {
      for (int i = 0; i < ITERATIONS; i++) {
        count++;
      }
    });

    thread.start();
    thread2.start();

    thread.join();
    thread2.join();

    System.out.println("예상 결과: 200000");
    System.out.println("실제 결과: " + count);
  }
}
