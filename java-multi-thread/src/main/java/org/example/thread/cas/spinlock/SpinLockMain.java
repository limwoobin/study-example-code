package org.example.thread.cas.spinlock;

import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

public class SpinLockMain {
  public static void main(String[] args) {
//    SpinLockBad spinLock = new SpinLockBad();
    SpinLock spinLock = new SpinLock();

    Runnable task = () -> {
      spinLock.lock();

      try {
        // critical section
        log("비즈니스 로직 실행");
      } finally {
        spinLock.unlock();
      }
    };

    Thread thread = new Thread(task, "Thread-1");
    Thread thread2 = new Thread(task, "Thread-2");

    thread.start();
    thread2.start();
  }
}
