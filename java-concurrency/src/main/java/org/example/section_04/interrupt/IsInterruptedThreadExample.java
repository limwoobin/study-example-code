package org.example.section_04.interrupt;

public class IsInterruptedThreadExample {
  public static void main(String[] args) throws InterruptedException {
    Thread worker = new Thread(() -> {
      while (!Thread.currentThread().isInterrupted()) {
        System.out.println("작업 스레드가 실행 중 입니다.");
      }

      System.out.println("인터럽트 상태: " + Thread.currentThread().isInterrupted());
      System.out.println("작업 스레드가 중단되었습니다.");
    });

    Thread stopper = new Thread(() -> {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      worker.interrupt();
      System.out.println("중단 스레드가 작업 스레드를 중단시켰습니다.");
    });

    worker.start();
    stopper.start();

    worker.join();
    stopper.join();

    System.out.println("Main 종료");
  }
}
