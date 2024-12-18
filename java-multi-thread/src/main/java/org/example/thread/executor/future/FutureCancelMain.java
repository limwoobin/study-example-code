package org.example.thread.executor.future;

import java.util.concurrent.*;

import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

public class FutureCancelMain {
//  private static boolean mayInterruptIfRunning = true;
  private static boolean mayInterruptIfRunning = false;

  public static void main(String[] args) {
    ExecutorService es = Executors.newFixedThreadPool(1);
    Future<String> future = es.submit(new MyTask());
    log("Future.state: " + future.state());

    sleep(3000);

    log("Future.cancel(" + mayInterruptIfRunning + ") 호출");
    boolean cancelResult = future.cancel(mayInterruptIfRunning);
    log("cancel(" + mayInterruptIfRunning + ") result:"  + cancelResult);

    try {
      log("Future.result: " + future.get());
    } catch (InterruptedException | ExecutionException e) {
      e.printStackTrace();
    } catch (CancellationException e) {
      log("Future.get() 취소됨");
    }
  }

  static class MyTask implements Callable<String> {

    @Override
    public String call() throws Exception {
      for (int i = 0; i < 10; i++) {
        try {
          log("작업 중: " + i);
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          log("인터럽트 발생");
          return "Interrupted";
        }

      }

      return "";
    }
  }
}
