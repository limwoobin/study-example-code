package org.example.step1.section_05.exam04;

public class ThreadSafeLocalVariableExample {
//  private int localSum = 0;
  public void printNumbers(int plus) {
    int localSum = 0;
    for (int i = 1; i <= 5; i++) {
      localSum += i;
      try {
        Thread.sleep(100);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    localSum += plus;
    System.out.println(Thread.currentThread().getName() + " 현재 합계: " + localSum);
  }

  public static void main(String[] args) {
    ThreadSafeLocalVariableExample example = new ThreadSafeLocalVariableExample();

    Thread thread = new Thread(() -> {
      example.printNumbers(10);
    });

    Thread thread2 = new Thread(() -> {
      example.printNumbers(20);
    });

    thread.start();
    thread2.start();
  }
}
