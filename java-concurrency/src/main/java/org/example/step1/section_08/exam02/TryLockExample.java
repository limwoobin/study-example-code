package org.example.step1.section_08.exam02;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TryLockExample {
  public static void main(String[] args) {
    Lock lock = new ReentrantLock();

    Thread thread = new Thread(() -> {
      boolean acquire = false;
      while (!acquire) {
        acquire = lock.tryLock();
        if (acquire) {
          System.out.println("스레드 1 락 획득");
          try {
            Thread.sleep(2000);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          } finally {
            lock.unlock();
            System.out.println("스레드 1 락 해제");
          }
        } else {
          System.out.println("스레드 1 락 획득 실패");
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      }
    });

    Thread thread2 = new Thread(() -> {
      boolean acquire = false;
      while (!acquire) {
        acquire = lock.tryLock();
        if (acquire) {
          System.out.println("스레드 2 락 획득");
          try {
//            Thread.sleep(2000);
          } finally {
            lock.unlock();
            System.out.println("스레드 2 락 해제");
          }
        } else {
          System.out.println("스레드 2 락 획득 실패");
          try {
            Thread.sleep(1000);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
        }
      }
    });

    thread.start();
    thread2.start();
  }
}
