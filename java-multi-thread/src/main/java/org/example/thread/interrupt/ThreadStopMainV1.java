package org.example.thread.interrupt;

import org.example.util.ThreadUtils;

import static org.example.util.MyLogger.log;

public class ThreadStopMainV1 {
  public static void main(String[] args) {
    MyTask myTask = new MyTask();
    Thread thread = new Thread(myTask, "worker");
    thread.start();

    ThreadUtils.sleep(4000);

    log("작업 중단 지시 runFlag=false");
    myTask.runFlag = false;
  }

  static class MyTask extends Thread {
    volatile boolean runFlag = true;

    @Override
    public void run() {
      while (runFlag) {
        log("작업 중");
        ThreadUtils.sleep(3000);
      }

      log("자원 정리");
      log("작업 종료");
    }
  }
}
