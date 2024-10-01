package org.example.step1.section_06.exam03;

public class ConditionSynchronizationExample {
  private boolean isAvailable = false;

  public synchronized void produce() {
    while (isAvailable) {
      try {
        wait();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    System.out.println("생산됨");
    this.isAvailable = true;
    notify();
  }

  public synchronized void consume() {
    while (!isAvailable) {
      try {
        wait();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    System.out.println("소비됨");
    this.isAvailable = false;
    notify();
  }

  public static void main(String[] args) {
    ConditionSynchronizationExample example = new ConditionSynchronizationExample();

    Thread thread = new Thread(() -> {
      for (int i = 0; i < 5; i++) {
        example.produce();
      }
    });

    Thread thread2 = new Thread(() -> {
      for (int i = 0; i < 5; i++) {
        example.consume();
      }
    });

    thread.start();
    thread2.start();
  }
}
