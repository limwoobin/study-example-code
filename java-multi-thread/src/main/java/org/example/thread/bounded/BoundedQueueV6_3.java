package org.example.thread.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.example.util.MyLogger.log;

public class BoundedQueueV6_3 implements BoundedQueue {

  private final BlockingQueue<String> queue;

  public BoundedQueueV6_3(int max) {
    this.queue = new ArrayBlockingQueue<>(max);
  }

  @Override
  public void put(String data) {
    boolean result = false;

    try {
      result = queue.offer(data, 1, TimeUnit.NANOSECONDS);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    log("저장 시도 결과 = " + result);
  }

  @Override
  public String take() {
    String data = null;

    try {
      data = queue.poll(1, TimeUnit.NANOSECONDS);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    log("반환 결과 = " + data);
    return data;
  }

  @Override
  public String toString() {
    return queue.toString();
  }
}
