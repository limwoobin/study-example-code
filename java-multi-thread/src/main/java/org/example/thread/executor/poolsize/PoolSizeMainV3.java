package org.example.thread.executor.poolsize;

import org.example.thread.executor.RunnableTask;

import java.util.concurrent.*;

import static org.example.thread.executor.ExecutorUtils.printState;
import static org.example.util.MyLogger.log;
import static org.example.util.ThreadUtils.sleep;

public class PoolSizeMainV3 {
  public static void main(String[] args) {
//    ExecutorService es = Executors.newCachedThreadPool();
    ExecutorService es = new ThreadPoolExecutor(0, Integer.MAX_VALUE,
      3L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>());

    log("pool 생성");
    printState(es);

    for (int i = 1; i <= 4; i++) {
      es.submit(new RunnableTask("task" + i));
      printState(es);
    }

    sleep(3000);
    log("== 작업 수행 완료 == ");

    es.close();
    log("== shutdown 완료 ==");
    printState(es);
  }
}
