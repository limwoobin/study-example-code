package org.example.thread.executor.poolsize;

import org.example.thread.executor.RunnableTask;

import java.util.concurrent.*;

import static org.example.thread.executor.ExecutorUtils.printState;
import static org.example.util.MyLogger.log;

public class PoolSizeMainV2 {
  public static void main(String[] args) {
    ExecutorService es = Executors.newFixedThreadPool(2);
//    ExecutorService es2 = new ThreadPoolExecutor(2, nThreads,
//      0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());

    log("pool 생성");
    printState(es);

    for (int i = 1; i <= 6; i++) {
      es.submit(new RunnableTask("task" + i));
      printState(es);
    }

    es.shutdown();
  }
}
