package org.example.section_04.thread_group;

public class ThreadGroupInterruptExample {
  public static void main(String[] args) throws InterruptedException {
    ThreadGroup topGroup = new ThreadGroup("상위 그룹");
    ThreadGroup subGroup = new ThreadGroup("하위 그룹");

    Thread topGroupThread = new Thread(topGroup, () -> {
      while (true) {
        System.out.println("상위 스레드 그룹 실행 중");
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }, "상위 그룹 스레드");

    Thread subGroupThread = new Thread(subGroup, () -> {
      while (true) {
        System.out.println("하위 스레드 그룹 실행 중");
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    }, "하위 그룹 스레드");

    topGroupThread.start();
    subGroupThread.start();

    Thread.sleep(2000);

    System.out.println("그룹 스레드 중지...");
    subGroup.interrupt();
    topGroup.interrupt();
  }
}
