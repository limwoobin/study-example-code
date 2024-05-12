package org.example.section_07.exam01;

public class SynchronizedExample {
  private int instanceCount = 0;
  private static int staticCount = 0;

  public synchronized void instanceMethod() {
    instanceCount++;
    System.out.println("인스턴스 메서드 동기화: " + instanceCount);
  }

  public static synchronized void staticMethod() {
    staticCount++;
    System.out.println("정적 메서드 동기화: " + staticCount);
  }

  public void instanceBlock() {
    synchronized (this) {
      instanceCount++;
      System.out.println("인스턴스 블록 동기화: " + instanceCount);
    }
  }

  public static void staticBlock() {
    synchronized (SynchronizedExample.class) {
      staticCount++;
      System.out.println("정적 블록 동기화: " + staticCount);
    }
  }

  public static void main(String[] args) {
    SynchronizedExample example = new SynchronizedExample();

    Thread thread = new Thread(example::instanceMethod);
    Thread thread2 = new Thread(example::instanceBlock);
    Thread thread3 = new Thread(SynchronizedExample::staticMethod);
    Thread thread4 = new Thread(SynchronizedExample::staticBlock);

    thread.start();
    thread2.start();
    thread3.start();
    thread4.start();
  }
}
