package org.example.step1.section_06.exam01;

public class Mutex {

  private boolean lock = false;
  public synchronized void acquired() {
    while (lock) {
      try {
        wait();
      } catch (Exception e) {
        throw new RuntimeException(e);
      }
    }

    this.lock = true;
  }

  public synchronized void release() {
    this.lock = false;
    this.notify();
  }
}
