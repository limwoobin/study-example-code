package org.example.step1.section_02.state;

public class TerminatedStateThreadExample {
  public static void main(String[] args) throws InterruptedException {
    Runnable runnable = () -> System.out.println("TERMINATED STATE !!");
    Thread thread = new Thread(runnable);
    thread.start();
    thread.join();

    System.out.println("state: " + thread.getState());
  }
}
