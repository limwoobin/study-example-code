package org.example.thread.volatile_example;

import org.example.util.ThreadUtils;

import static org.example.util.MyLogger.log;

public class VolatileFlagMain {
  public static void main(String[] args) {
    MyTask task = new MyTask();
    Thread work = new Thread(task, "work");;
    log("runFlag = " + task.runFlag);
    work.start();

    ThreadUtils.sleep(1000);
    log("runFlag false 로 변경");
    task.runFlag = false;
    log("runFlag = " + task.runFlag);
    log("main 종료");
  }

  static class MyTask implements Runnable {
//    boolean runFlag = true;
    volatile boolean runFlag = true;

    @Override
    public void run() {
      log("task 시작");

      while (runFlag) {
        // runFlag 가 false 로 변하면 탈출
      }

      log("task 종료");
    }
  }
}
