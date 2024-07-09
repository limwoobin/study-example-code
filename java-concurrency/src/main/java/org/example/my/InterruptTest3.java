package org.example.my;

public class InterruptTest3 {
  public static void main(String[] args) {
    Thread target = new TargetThread();
    target.start();

    try {
      Thread.sleep(1000);
      target.interrupt();
      System.out.println("main: " + target.isInterrupted());
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

  static class TargetThread extends Thread {

    @Override
    public void run() {
      while (!Thread.currentThread().isInterrupted()) {
        System.out.println("sleeping... ");
        try {
          Thread.sleep(100);
        } catch (InterruptedException e) {
          System.out.println("Thread.currentThread().isInterrupted(): " + Thread.currentThread().isInterrupted());
          System.out.println("Interrupted!!");
//          Thread.currentThread().interrupt();
        }
      }

//      System.out.println("Interrupted!!");
    }
  }
}
