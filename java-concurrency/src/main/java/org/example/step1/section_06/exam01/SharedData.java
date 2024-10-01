package org.example.step1.section_06.exam01;

public class SharedData {
  private int sharedValue = 0;

  private Mutex mutex;

  public SharedData(Mutex mutex) {
    this.mutex = mutex;
  }

  public void sum() {
    try {
      mutex.acquired();

      for (int i = 1; i <= 1000000; i++) {
        sharedValue++;
      }
    } finally {
      mutex.release();
    }
  }

  public int getSum() {
    return sharedValue;
  }
}
