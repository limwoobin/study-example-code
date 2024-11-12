package org.example.thread.sync.lock;

import org.example.util.ThreadUtils;

import java.util.concurrent.locks.LockSupport;

import static org.example.util.MyLogger.log;

public class LockSupportMainV2 {
  public static void main(String[] args) {
    Thread thread = new Thread(new ParkTest(), "Thread-1");
    thread.start();

    ThreadUtils.sleep(100);
    log("Thread-1 state: " + thread.getState());
  }

  static class ParkTest implements Runnable {

    @Override
    public void run() {
      log("park 시작");
      LockSupport.parkNanos(2_000_000_000);
      log("park 종료, stage: " + Thread.currentThread().getState());
      log("인터럽트 상턔: " + Thread.currentThread().isInterrupted());
    }
  }
}
