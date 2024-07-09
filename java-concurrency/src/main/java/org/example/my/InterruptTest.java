package org.example.my;

public class InterruptTest {
  public static void main(String[] args) {
    Runnable runnable = () -> {
      try {
        System.out.println("Thread is going to sleep.");
        Thread.sleep(5000); // 5 seconds
      } catch (InterruptedException e) {
        System.out.println("Thread was interrupted.");
        Thread.currentThread().interrupt(); // Preserve interrupt status
      }
      System.out.println("Thread has woken up.");
    };

    Thread thread = new Thread(runnable);
    thread.start();

    try {
      Thread.sleep(2000);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }

    thread.interrupt();
  }
}
