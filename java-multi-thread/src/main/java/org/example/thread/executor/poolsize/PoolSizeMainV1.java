package org.example.thread.executor.poolsize;

import org.example.thread.executor.RunnableTask;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static org.example.thread.executor.ExecutorUtils.printState;

public class PoolSizeMainV1 {
  public static void main(String[] args) {
    ArrayBlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(2);
    ExecutorService es = new ThreadPoolExecutor(2, 4,
      3000, TimeUnit.MILLISECONDS, workQueue);
    printState(es);

    es.execute(new RunnableTask("task1"));
    printState(es, "task1");

    es.execute(new RunnableTask("task2"));
    printState(es, "task2");

    es.execute(new RunnableTask("task3"));
    printState(es, "task3");
  }
}
