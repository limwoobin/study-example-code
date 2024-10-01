package org.example.step1.section_03.interrupt;

public class InterruptExample {
  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(() -> {
      System.out.println("스레드 1 작업 시작");
      System.out.println("스레드 1 인터럽트 상태: " + Thread.currentThread().isInterrupted());
    });

    Thread thread2 = new Thread(() -> {
      System.out.println("스레드 2 가 스레드1 을 인터럽트 합니다");
      thread.interrupt();
      System.out.println("스레드 2 인터럽트 상태: " + Thread.currentThread().isInterrupted());
    });

    thread2.start();
    Thread.sleep(1000);
    thread.start();

    thread.join();
    thread2.join();

    System.out.println("모든 스레드 작업 완료");
  }
}
