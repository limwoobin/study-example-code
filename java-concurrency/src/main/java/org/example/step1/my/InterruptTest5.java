package org.example.step1.my;

public class InterruptTest5 {
  public static void main(String[] args) throws InterruptedException {
    Thread target = new Thread(() -> {
      while (!Thread.currentThread().isInterrupted()) {
//        System.out.println("Thread.currentThread().isInterrupted(): " + Thread.currentThread().isInterrupted());

        try {
          Thread.sleep(200);
          System.out.println("Thread.currentThread().isInterrupted(): " + Thread.currentThread().isInterrupted());
        } catch (InterruptedException e) {
//          System.out.println("interrupted !!");
//          Thread.currentThread().interrupt();
        }
      }
    });

    target.start();
    Thread.sleep(2000);
    target.interrupt();
    
//    Thread.interrupted();
  }
}
