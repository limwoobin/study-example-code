package org.example.step1.section_03.join;

import java.util.Properties;

public class BasicJoinExample {
  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(() -> {
      try {
        System.out.println("스레드가 3초 동안 작동합니다.");
        Thread.sleep(3000);
        System.out.println("스레드 작동 완료");
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    });

    thread.start();
    thread.join();

    System.out.println("Main 종료");
  }
}
