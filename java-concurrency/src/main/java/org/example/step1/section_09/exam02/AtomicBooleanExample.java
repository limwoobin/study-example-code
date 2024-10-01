package org.example.step1.section_09.exam02;

import java.util.concurrent.atomic.AtomicBoolean;

public class AtomicBooleanExample {

  private static AtomicBoolean flag = new AtomicBoolean(false);

  public static void main(String[] args) {
    Thread thread = new Thread(() -> {
      for (int i = 0; i < 5; i++) {
        while (flag.compareAndSet(false, true)) {
          System.out.println("스레드 1 이 바쁜 대기 중");
        }

        System.out.println("스레드 1이 임계영역 수행 중");
        flag.set(false);

        try {
          Thread.sleep(1);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    });

    Thread thread2 = new Thread(() -> {
      for (int i = 0; i < 5; i++) {
        while (flag.compareAndSet(false, true)) {
          System.out.println("스레드 2 이 바쁜 대기 중");
        }

        System.out.println("스레드 2 이 임계영역 수행 중");
        flag.set(false);

        try {
          Thread.sleep(1);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    });

    thread.start();
    thread2.start();
  }
}
