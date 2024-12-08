package org.example.thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CasMainV1 {
  public static void main(String[] args) {
    AtomicInteger atomicInteger = new AtomicInteger(0);
    System.out.println("start value = " + atomicInteger.get());

    boolean result = atomicInteger.compareAndSet(0, 2);
    System.out.println(result);
    System.out.println(atomicInteger.get());
  }
}
