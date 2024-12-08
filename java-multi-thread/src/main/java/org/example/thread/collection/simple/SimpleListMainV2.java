package org.example.thread.collection.simple;

import org.example.thread.collection.simple.list.BasicList;
import org.example.thread.collection.simple.list.SimpleList;
import org.example.thread.collection.simple.list.SyncList;
import org.example.thread.collection.simple.list.SyncProxyList;

import static org.example.util.MyLogger.log;

public class SimpleListMainV2 {
  public static void main(String[] args) throws InterruptedException {
//    test(new BasicList());
//    test(new SyncList());

    BasicList basicList = new BasicList();
    SyncProxyList proxyList = new SyncProxyList(basicList);
    test(proxyList);
  }

  private static void test(SimpleList list) throws InterruptedException {
    log(list.getClass().getSimpleName());

    Runnable addA = () -> {
      list.add("A");
      log("Thread-1: list.add(A)");
    };

    Runnable addB = () -> {
      list.add("B");
      log("Thread-2: list.add(B)");
    };

    Thread thread = new Thread(addA, "Thread-1");
    Thread thread2 = new Thread(addB, "Thread-2");

    thread.start();
    thread2.start();
    thread.join();
    thread2.join();

    log(list.toString());
  }
}
