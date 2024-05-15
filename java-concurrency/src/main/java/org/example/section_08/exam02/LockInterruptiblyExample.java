package org.example.section_08.exam02;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptiblyExample {
  public static void main(String[] args) throws InterruptedException {
    Lock lock = new ReentrantLock();

    Thread thread = new Thread(() -> {
      try {
        lock.lockInterruptibly();
        try {
          System.out.println("스레드 1 락 획득");
        } finally {
          lock.unlock();
          System.out.println("스레드 1 락 해제");
        }
      } catch (InterruptedException e) {
        System.out.println("스레드 1 이 인터럽트를 받음");
      }
    });

    Thread thread2 = new Thread(() -> {
      try {
        lock.lockInterruptibly();
        try {
          System.out.println("스레드 2 락 획득");
        } finally {
          lock.unlock();
          System.out.println("스레드 2 락 해제");
        }
      } catch (InterruptedException e) {
        System.out.println("스레드 2 이 인터럽트를 받음");
      }
    });

    thread.start();
    thread2.start();

    thread.join();
    thread2.join();
  }
}
