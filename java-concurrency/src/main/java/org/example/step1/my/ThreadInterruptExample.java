package org.example.step1.my;

public class ThreadInterruptExample {
  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(() -> {
      try {
        System.out.println(Thread.currentThread().getName() + "start");
        Thread.sleep(10000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });

    Thread thread2 = new Thread(() -> {
      System.out.println(Thread.currentThread().getName() + "start");
      System.out.println("thread.getState(): " + thread.getState());
      thread.interrupt();
    });

    System.out.println("thread2.getState(): " + thread2.getState());

    thread.start();
    thread2.start();

    System.out.println("thread2.getState(): " + thread2.getState());

    thread.join();
    thread2.join();

    System.out.println("Thread End");
  }
}
