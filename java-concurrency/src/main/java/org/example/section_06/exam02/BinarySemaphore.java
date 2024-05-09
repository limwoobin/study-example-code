package org.example.section_06.exam02;

public class BinarySemaphore implements CommonSemaphore {
  private int signal = 1;

  @Override
  public synchronized void acquired() {
    while (signal == 0) {
      try {
        wait();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    this.signal = 0;
  }

  @Override
  public synchronized void release() {
    signal = 1;
    notify();
  }
}
