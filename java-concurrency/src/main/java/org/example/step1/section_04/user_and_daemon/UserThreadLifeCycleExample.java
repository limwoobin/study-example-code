package org.example.step1.section_04.user_and_daemon;

public class UserThreadLifeCycleExample {
  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(() -> {
      for (int i = 0; i < 3; i++) {
        System.out.println("사용자 스레드 1 실행 중..");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }

      System.out.println("사용자 스레드 1 종료");
    });

    Thread thread2 = new Thread(() -> {
      for (int i = 0; i < 3; i++) {
        System.out.println("사용자 스레드 2 실행 중..");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }

      System.out.println("사용자 스레드 2 종료");
    });


    thread.start();
    thread2.start();

    thread.join();
    thread2.join();

    System.out.println("모든 사용자 스레드가 종료되었습니다.");
  }
}
