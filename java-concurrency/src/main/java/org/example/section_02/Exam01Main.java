package org.example.section_02;

public class Exam01Main {
  public static void main(String[] args) {
    Thread thread = new WorkerThread();
    thread.start();

    Runnable runnable = new ExecuteTask();
    Thread thread2 = new Thread(runnable);
    thread2.start();

    System.out.println("main current: " + Thread.currentThread().getName());
  }
}
