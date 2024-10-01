package org.example.step1.my;

public class InterruptTest4 {
  public static void main(String[] args) {
    Thread target = new TargetThread();
    target.start();

    System.out.println("state: " + target.isInterrupted());

    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    target.interrupt();
//    Thread.interrupted();
    System.out.println("state: " + target.isInterrupted());
  }

  static class TargetThread extends Thread {

    @Override
    public void run() {
      while (!Thread.currentThread().isInterrupted()) {
        System.out.println("sleep...");
      }

      System.out.println("end...");
    }
  }
}
