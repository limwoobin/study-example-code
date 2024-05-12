package org.example.section_07.exam01;

public class InstanceMethodSynchronizedExample02 {
  private int count = 0;

  public synchronized void increment() {
    count++;
    System.out.println(Thread.currentThread().getName() + "가 증가시켰습니다. 현재 값: " + count);
  }

  public synchronized void decrement() {
    count--;
    System.out.println(Thread.currentThread().getName() + "가 감소시켰습니다. 현재 값: " + count);
  }

  public int getCount() {
    return count;
  }
  public static void main(String[] args) throws InterruptedException {
    InstanceMethodSynchronizedExample02 counter = new InstanceMethodSynchronizedExample02();
    InstanceMethodSynchronizedExample02 counter2 = new InstanceMethodSynchronizedExample02();

    Thread thread = new Thread(() -> {
      for (int i = 0; i < 5000; i++) {
        counter.increment();
        counter2.decrement();
      }
    });

    Thread thread2 = new Thread(() -> {
      for (int i = 0; i < 5000; i++) {
        counter.decrement();
        counter2.increment();
      }
    });

    thread.start();
    thread2.start();

    thread.join();
    thread2.join();

    System.out.println("결과: " + counter.getCount());
    System.out.println("결과: " + counter2.getCount());
  }
}
