package org.example.thread.executor.future;

import java.util.concurrent.*;

import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

public class FutureExceptionMain {
  public static void main(String[] args) {
    ExecutorService es = Executors.newFixedThreadPool(1);
    log("작업 전달");
    Future<String> future = es.submit(new ExCallable());
    sleep(1000);

    try {
      log("future.get() 호출 시도, future.state(): " + future.state());
      String result = future.get();
      log("result = " + result);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } catch (ExecutionException e) {
      log("e= " + e);
      Throwable cause = e.getCause();
      log("cause= " + cause);
    }
  }

  static class ExCallable implements Callable<String> {

    @Override
    public String call() throws Exception {
      log("Callable 실행, 예외 발셍");
      throw new IllegalStateException("ex!");
    }
  }
}
