package org.example;

public class Main {
  public static void main(String[] args) {
    System.out.println(Thread.currentThread().getName());
    System.out.println(Thread.currentThread().getId());
    System.out.println(Thread.currentThread().getState());
  }
}
