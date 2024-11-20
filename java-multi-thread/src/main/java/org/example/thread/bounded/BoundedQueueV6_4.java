package org.example.thread.bounded;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static org.example.util.MyLogger.log;

public class BoundedQueueV6_4 implements BoundedQueue {

  private final BlockingQueue<String> queue;

  public BoundedQueueV6_4(int max) {
    this.queue = new ArrayBlockingQueue<>(max);
  }

  @Override
  public void put(String data) {
    boolean result = queue.add(data);

    log("저장 시도 결과 = " + result);
  }

  @Override
  public String take() {
    String data = queue.remove();
    log("반환 결과 = " + data);
    return data;
  }

  @Override
  public String toString() {
    return queue.toString();
  }
}
