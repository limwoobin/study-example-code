package org.example.section_10.exam01;

import java.util.LinkedList;
import java.util.Queue;

public class SimpleThreadPool {
  private int numThreads;
  private Queue<Runnable> taskQueue;
  private Thread[] threads;
  private volatile boolean isShutdown;

  public SimpleThreadPool(int numThreads) {
    this.numThreads = numThreads;
    this.taskQueue = new LinkedList<>();
    this.threads = new Thread[numThreads];
    this.isShutdown = false;

    for (int i = 0; i < numThreads; i++) {
      threads[i] = new WorkerThread();
      threads[i].start();
    }
  }

  public void submit(Runnable task) {
    if (!isShutdown) {
      synchronized (taskQueue) {
        taskQueue.offer(task);
        taskQueue.notifyAll();
      }
    }
  }

  public void shutdown() {
    this.isShutdown = true;
    synchronized (taskQueue) {
      taskQueue.notifyAll();
    }

    for (Thread thread : threads) {
      try {
        thread.join();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

  private class WorkerThread extends Thread {

    @Override
    public void run() {
      while (!isShutdown) {
        Runnable task;
        synchronized (taskQueue) {
          while (taskQueue.isEmpty() && !isShutdown) {
            try {
              taskQueue.wait();
            } catch (InterruptedException e) {
              throw new RuntimeException(e);
            }
          }
        }

        if (!taskQueue.isEmpty()) {
          task = taskQueue.poll();
        } else {
          continue;
        }

        task.run();
      }
    }
  }

}
