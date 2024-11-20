package org.example.thread.bounded;

import static org.example.util.MyLogger.log;

public class ProductTask implements Runnable {
  private BoundedQueue queue;
  private String request;

  public ProductTask(BoundedQueue queue, String request) {
    this.queue = queue;
    this.request = request;
  }

  @Override
  public void run() {
    log("[생산 시도] " + request + " -> " + queue);
    queue.put(request);
    log("[생산 완료] " + request + " -> " + queue);
  }
}
