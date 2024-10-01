package org.example.step1.my;

public class StateTest {
  public static void main(String[] args) {
    Thread thread = new Thread(() -> {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });

    thread.start();

    try {
      Thread.sleep(50);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    System.out.println(thread.getState());
  }
}
