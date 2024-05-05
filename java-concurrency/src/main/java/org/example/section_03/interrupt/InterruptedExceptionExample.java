package org.example.section_03.interrupt;

public class InterruptedExceptionExample {
  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(() -> {
      System.out.println("인터럽트 상태1: " + Thread.currentThread().isInterrupted());

      try {
        Thread.sleep(5000);
      } catch (InterruptedException e) {
        System.out.println("스레드가 인터럽트 되었습니다.");
        System.out.println("인터럽트 상태2: " + Thread.currentThread().isInterrupted());
        Thread.currentThread().interrupt();
      }
    });

    thread.start();

    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    thread.interrupt();
    thread.join();
    System.out.println("인터럽트 상태3: " + thread.isInterrupted());
  }
}
