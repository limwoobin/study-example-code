package org.example.step1.my;

public class InterruptTest6 {
  public static void main(String[] args) {
    System.out.println(Thread.currentThread().isInterrupted());
    Thread.currentThread().interrupt();
    System.out.println(Thread.currentThread().isInterrupted());

    Thread.interrupted();
    System.out.println(Thread.currentThread().isInterrupted());
  }
}
