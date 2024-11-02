package org.example.thread.control;

import static org.example.util.MyLogger.*;


public class ManyThreadMainV1 {
  public static void main(String[] args) {
    log("Main Thread Start V1");

    Thread thread = new Thread(() -> log("thread1"));
    Thread thread2 = new Thread(() -> log("thread2"));
    thread.start();
    thread2.start();

    log("Main Thread End V1");
  }
}
