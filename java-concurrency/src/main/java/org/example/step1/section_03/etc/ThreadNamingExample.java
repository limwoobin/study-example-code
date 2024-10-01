package org.example.step1.section_03.etc;

public class ThreadNamingExample {
  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(() -> {
      System.out.println("현재 스레드 이름: " + Thread.currentThread().getName());
    }, "myThread");
    thread.start();

    Thread otherThread = new Thread(() -> {
      System.out.println("현재 스레드 이름: " + Thread.currentThread().getName());
    });
    otherThread.setName("otherThread");
    otherThread.start();

    for (int i = 0; i < 5; i++) {
      Thread basicThread = new Thread(() -> {
        System.out.println("현재 스레드 이름: " + Thread.currentThread().getName());
      });

      basicThread.start();
    }

    Thread.sleep(2000);
  }
}
