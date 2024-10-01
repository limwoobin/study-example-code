package org.example.step1.section_04.thread_local;

public class ThreadLocalExample {
//  private static ThreadLocal<String> threadLocal = new ThreadLocal<>();
  private static ThreadLocal<String> threadLocal = ThreadLocal.withInitial(() -> "Hello World");

  public static void main(String[] args) {
    Thread thread = new Thread(() -> {
      System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
      threadLocal.set("스레드 1의 값");
      System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
    }, "Thread-1");

    Thread thread2 = new Thread(() -> {
      System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
      threadLocal.set("스레드 2의 값");
      System.out.println(Thread.currentThread().getName() + ": " + threadLocal.get());
    }, "Thread-2");

    thread.start();
    thread2.start();
  }
}
