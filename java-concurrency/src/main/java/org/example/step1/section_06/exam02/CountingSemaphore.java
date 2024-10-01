package org.example.step1.section_06.exam02;

public class CountingSemaphore implements CommonSemaphore {
  private int signal;
  private final int permits;

  public CountingSemaphore(int permits) {
    this.signal = permits;
    this.permits = permits;
  }

  @Override
  public synchronized void acquired() {
    while (signal == 0) {
      try {
        wait();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    this.signal--;
    System.out.println(Thread.currentThread().getName() + " 락 획득, 현재 세마포어 값: " + signal);
  }

  @Override
  public synchronized void release() {
    if (signal < permits) {
      this.signal++;
      System.out.println(Thread.currentThread().getName() + " 락 해제, 현재 세마포어 값: " + signal);
      this.notify();
    }
  }
}
