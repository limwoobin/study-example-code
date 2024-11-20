package org.example.thread.bounded;

public interface BoundedQueue {
  void put(String data);

  String take();
}
