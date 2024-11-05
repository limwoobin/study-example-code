package org.example.thread.yield;

import org.example.util.ThreadUtils;

public class YieldMain {
  static final int THREAD_COUNT = 1000;

  public static void main(String[] args) {
    for (int i = 0; i < THREAD_COUNT; i++) {
      Thread thread = new Thread(new MyRunnable());
      thread.start();
    }
  }

  static class MyRunnable implements Runnable {

    @Override
    public void run() {
      for (int i = 0; i < 10; i++) {
        System.out.println(Thread.currentThread().getName() + " " + i);
        // 1. empty - sleep(1), yield 를 사용하지 않은것
        // 2. sleep(1)
        // 3. yield
        // ThreadUtils.sleep(1);
        Thread.yield();
      }
    }
  }
}
