package org.example.section_03.interrupt;

public class InterruptedExample_V2 {
  public static void main(String[] args) {
    Thread thread2 = new Thread(() -> {
      while (!Thread.interrupted()) {
        System.out.println("스레드 2 작동 중");
      }

      System.out.println("인터럽트 상태: " + Thread.currentThread().isInterrupted());
    });

    Thread thread = new Thread(() -> {
      for (int i=0; i<5; i++) {
        System.out.println("스레드 1 작동 중..");
        if (i == 2) {
          thread2.interrupt();
        }

        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
        }
      }
    });

    thread.start();
    thread2.start();
  }
}
