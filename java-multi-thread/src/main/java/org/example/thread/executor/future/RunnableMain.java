package org.example.thread.executor.future;

import java.util.Random;

import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

public class RunnableMain {
  public static void main(String[] args) throws InterruptedException {
    MyRunnable task = new MyRunnable();
    Thread thread = new Thread(task, "Thread-1");
    thread.start();
    thread.join();

    int result = task.value;
    log("result = " + result);
  }

  static class MyRunnable implements Runnable {
    int value;

    @Override
    public void run() {
      log("Runnable 시작");
      sleep(2000);
      value = new Random().nextInt(10);
      log("create value = " + value);
      log("Runnable 완료");
    }
  }
}
