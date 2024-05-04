package org.example.section_03;

public class NewStateThreadExample {
  public static void main(String[] args) {
    Runnable runnable = () -> System.out.println("NEW STATE !!");
    Thread thread = new Thread(runnable);
    Thread.State state = thread.getState();

    System.out.println("state: " + state);
  }
}
