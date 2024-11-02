package org.example.thread.control;

import static org.example.util.MyLogger.log;

public class InnerRunnableV1 {
  public static void main(String[] args) {
    log("main() started");

    MyRunnable runnable = new MyRunnable();
    Thread thread = new Thread(runnable);
    thread.start();

    log("main() end");
  }

  static class MyRunnable implements Runnable {
    @Override
    public void run() {
      log("MyRunnable.run() started");
      log("MyRunnable.run() end");
    }
  }
}
