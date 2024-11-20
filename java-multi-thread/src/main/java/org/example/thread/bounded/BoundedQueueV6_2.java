package org.example.thread.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static org.example.util.MyLogger.log;

public class BoundedQueueV6_2 implements BoundedQueue {

  private final BlockingQueue<String> queue;

  public BoundedQueueV6_2(int max) {
    this.queue = new ArrayBlockingQueue<>(max);
  }

  @Override
  public void put(String data) {
    boolean result = queue.offer(data);
    log("저장 시도 결과 = " + result);
  }

  @Override
  public String take() {
    String data = queue.poll();
    log("반환 결과 = " + data);
    return data;
  }

  @Override
  public String toString() {
    return queue.toString();
  }
}
