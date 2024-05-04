package org.example.section_02;

public class Exam01Main {
  public static void main(String[] args) {
    Thread thread = new WorkerThread();
    System.out.println(thread.getState());
    thread.start();
    System.out.println(thread.getState());

    Runnable runnable = new ExecuteTask();
    Thread thread2 = new Thread(runnable);
    thread2.start();

    System.out.println("main current: " + Thread.currentThread().getName());
  }
}
