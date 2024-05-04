package org.example.section_02;

public class WorkerThread extends Thread {

  @Override
  public void run() {
    Thread thread = Thread.currentThread();
    System.out.println(thread.getState());
    System.out.println("HI");
  }
}
