package org.example.thread.bounded;

import org.example.util.ThreadUtils;

import java.util.ArrayDeque;
import java.util.Queue;

import static org.example.util.MyLogger.log;

public class BoundedQueueV3 implements BoundedQueue {
  private final Queue<String> queue = new ArrayDeque<>();
  private final int max;

  public BoundedQueueV3(int max) {
    this.max = max;
  }

  @Override
  public synchronized void put(String data) {
    while (queue.size() == max) {
      log("[put] 큐가 가득 참, 생산자 대기: " + data);
      try {
        wait(); // RUNNABLE -> WAITING, 락 반납
        log("[put] 생산자 대기 해제: " + data);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    queue.offer(data);
    log("[put] 생산자 데이터 저장. notify() 호출 ");
    notify(); // WAITING -> BLOCKED, 락 획득
  }

  @Override
  public synchronized String take() {
    while (queue.isEmpty()) {
      log("[take] 큐가 비어 있음, 소비자 대기");
      try {
        wait();
        log("[take] 소비자 대기 해제");
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }

    String data = queue.poll();
    log("[take] 소비자 데이터 획득. notify() 호출");
    notify(); // WAITING -> BLOCKED, 락 획득
    return data;
  }

  @Override
  public String toString() {
    return queue.toString();
  }
}
