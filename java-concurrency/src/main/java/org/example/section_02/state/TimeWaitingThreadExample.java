package org.example.section_02.state;

public class TimeWaitingThreadExample {
  public static void main(String[] args) throws InterruptedException {
    Runnable runnable = () -> {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    };

    Thread thread = new Thread(runnable);
    thread.start();
    Thread.sleep(100);

    System.out.println("state: " + thread.getState());
  }
}
