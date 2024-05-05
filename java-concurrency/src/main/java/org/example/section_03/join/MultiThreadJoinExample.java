package org.example.section_03.join;

public class MultiThreadJoinExample {
  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(() -> {
      try {
        System.out.println("스레드1이 3초 동안 작동합니다.");
        Thread.sleep(3000);
        System.out.println("스레드1 작동 완료");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    Thread thread2 = new Thread(() -> {
      try {
        System.out.println("스레드2가 2초 동안 작동합니다.");
        Thread.sleep(2000);
        System.out.println("스레드2 작동 완료");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    thread.start();
    thread2.start();

    System.out.println("Main 시작");

    thread.join();
    thread2.join();

    System.out.println("Main 종료");
  }
}
