package org.example.section_02.state;

public class BlockedStateThreadExample {
  public static void main(String[] args) throws InterruptedException {
    Object lock = new Object();

    Runnable runnable = () -> {
      synchronized (lock) {
        while (true) {

        }
      }
    };

    Thread thread = new Thread(runnable);

    Runnable runnable2 = () -> {
      synchronized (lock) {
        System.out.println("락을 획득하려고 함");
      }
    };

    thread.start();
    Thread.sleep(100);

    Thread thread2 = new Thread(runnable2);
    thread2.start();
    Thread.sleep(100);

    System.out.println("state: " + thread.getState());
    System.out.println("state2: " + thread2.getState());
  }
}
