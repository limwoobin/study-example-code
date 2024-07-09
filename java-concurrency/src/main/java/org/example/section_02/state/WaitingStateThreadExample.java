package org.example.section_02.state;

public class WaitingStateThreadExample {
  public static void main(String[] args) throws InterruptedException {
    Object lock = new Object();

    Runnable runnable = () -> {
      synchronized (lock) {
        try {
          lock.wait();
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    };

    Thread thread = new Thread(runnable);
    thread.start();
    Thread.sleep(1000);

    System.out.println("state: " + thread.getState());
  }
}
