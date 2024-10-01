package org.example.step1.section_08.exam01;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockOrderExample {
  private static final Lock lock1 = new ReentrantLock();
  private static final Lock lock2 = new ReentrantLock();

  public static void main(String[] args) {
    new Thread(() -> {
      lock1.lock();
      try {
        System.out.println("1번 락 획득");
        lock2.lock();
        try {
          System.out.println("2번 락 획득");
        } finally {
          System.out.println("1번 락 해제");
          lock1.unlock();
        }
      } finally {
        lock2.unlock();
        System.out.println("2번 락 해제");
      }
    }).start();

    Thread thread2 = new Thread(() -> {

    });
  }
}
