package org.example.section_03.interrupt;

public class IsInterruptedExample {
  public static void main(String[] args) {
    Thread thread = new Thread(() -> {
      while (!Thread.currentThread().isInterrupted()) {
        System.out.println("스레드는 계속 작동중입니다.");
      }

      System.out.println("스레드가 인터럽트 되었습니다.");
      System.out.println("인터럽트 상태: " + Thread.currentThread().isInterrupted());
    });

    thread.start();

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    thread.interrupt();
  }
}
