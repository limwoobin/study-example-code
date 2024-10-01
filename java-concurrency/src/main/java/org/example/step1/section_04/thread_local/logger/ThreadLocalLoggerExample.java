package org.example.step1.section_04.thread_local.logger;

public class ThreadLocalLoggerExample {
  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(new LogWorker());
    Thread thread2 = new Thread(new LogWorker());
    Thread thread3 = new Thread(new LogWorker());

    thread.start();
    thread2.start();
    thread3.start();

    thread.join();
    thread2.join();
    thread3.join();
  }
}
