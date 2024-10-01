package org.example.step1.section_06.exam02;

public class SharedResource {
  private int sharedValue = 0;

  private final CommonSemaphore semaphore;

  public SharedResource(CommonSemaphore semaphore) {
    this.semaphore = semaphore;
  }

  public void sum() {
    try {
      semaphore.acquired();

      for (int i = 1; i <= 1000000; i++) {
        sharedValue++;
      }
    } finally {
      semaphore.release();
    }
  }

  public int getSum() {
    return sharedValue;
  }
}
