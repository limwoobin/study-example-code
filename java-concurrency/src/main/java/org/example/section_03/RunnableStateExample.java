package org.example.section_03;

public class RunnableStateExample {
  public static void main(String[] args) {
    Runnable runnable = () -> System.out.println("Thread State: " + Thread.currentThread().getState());
    Thread thread = new Thread(runnable);
    thread.start();
    Thread.State state = thread.getState();

    System.out.println("state: " + state);
  }
}
