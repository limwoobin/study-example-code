package org.example.thread.volatile_example;

import org.example.util.ThreadUtils;

import static org.example.util.MyLogger.log;

public class VolatileCountMain {
  public static void main(String[] args) {
    MyTask task = new MyTask();
    Thread work = new Thread(task, "work");;
    log("flag = " + task.flag);
    work.start();

    ThreadUtils.sleep(1000);
    log("flag false 로 변경");
    task.flag = false;
    log("flag = " + task.flag + ", count = " + task.count + " in main thread");
    log("main 종료");
  }

  static class MyTask implements Runnable {
//    boolean flag = true;
//    long count;

    volatile boolean flag = true;
    volatile long count;

    @Override
    public void run() {
      while (flag) {
        count++;
        // 1억번에 한번씩
        if (count % 100_000_000 == 0) {
          log("flag = " + flag + ", count: " + count + " in while");
        }
      }

      log("flag = " + flag + ", count: " + count + " 종료");
    }

  }
}
