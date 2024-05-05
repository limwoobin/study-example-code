package org.example.section_03.priority;

public class ThreadPriorityExample {
  public static void main(String[] args) throws InterruptedException {
    Thread maxThread = new CountingThread("우선 순위가 높은 스레드", Thread.MAX_PRIORITY);
    Thread normThread = new CountingThread("우선 순위가 기본 스레드", Thread.NORM_PRIORITY);
    Thread minThread = new CountingThread("우선 순위가 낮은 스레드", Thread.MIN_PRIORITY);

    maxThread.start();
    normThread.start();
    minThread.start();

    maxThread.join();
    normThread.join();
    minThread.join();

    System.out.println("Main 종료");
  }

  static class CountingThread extends Thread {
    private final String threadName;
    private int count = 0;

    public CountingThread(String threadName, int priority) {
      this.threadName = threadName;
      setPriority(priority);
    }

    @Override
    public void run() {
      while (count < 10000000) {
        count++;
      }

      System.out.println(threadName + ": " + count);
    }
  }
}
