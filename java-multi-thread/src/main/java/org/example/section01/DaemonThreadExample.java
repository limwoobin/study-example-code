package org.example.section01;

public class DaemonThreadExample {
  public static void main(String[] args) {
    DaemonThread thread = new DaemonThread();
    thread.setDaemon(true);

    System.out.println("Main Thread Start");
    thread.start();
    System.out.println("Main Thread End");
  }

  static class DaemonThread extends Thread {

    @Override
    public void run() {
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }

      System.out.println("Daemon Thread");
    }
  }
}
