package org.example.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.example.thread.executor.ExecutorUtils.printState;
import static org.example.util.MyLogger.log;

public class ExecutorShutdownMain {
  public static void main(String[] args) {
    ExecutorService es = Executors.newFixedThreadPool(2);
    es.execute(new RunnableTask("taskA"));
    es.execute(new RunnableTask("taskB"));
    es.execute(new RunnableTask("taskC"));
    es.execute(new RunnableTask("taskA", 100_000));
    printState(es);

    log("== shutdown 시작");
    shutdownAndAwaitTermination(es);
    log("== shutdown 종료");
    printState(es);
  }

  private static void shutdownAndAwaitTermination(ExecutorService es) {
    es.shutdown();

    try {
      // 이미 대기중인 작업들을 모두 완료할때까지 10초 대기
      if (!es.awaitTermination(10, TimeUnit.SECONDS)) {
        log("서비스 정상 종료 실패 -> 강제 종료 시도");
        es.shutdownNow();

        // 작업이 취소될 때 까지 대기
        if (!es.awaitTermination(10, TimeUnit.SECONDS)) {
          log("서비스 강제 종료 실패");
        }
      }
    } catch (InterruptedException e) {
      es.shutdownNow();
    }
  }
}
