package org.example.thread.cas;

import java.util.concurrent.atomic.AtomicInteger;

import static org.example.util.MyLogger.log;

public class CasMainV2 {
  public static void main(String[] args) {
    AtomicInteger atomicInteger = new AtomicInteger(0);
    System.out.println("start value = " + atomicInteger.get());

    int resultValue1 = incrementAndGet(atomicInteger);
    System.out.println("resultValue1 = " + resultValue1);

    int resultValue2 = incrementAndGet(atomicInteger);
    System.out.println("resultValue2 = " + resultValue2);
  }

  private static int incrementAndGet(AtomicInteger atomicInteger) {
    int getValue;
    boolean result;

    do {
      getValue = atomicInteger.get();
      log("getValue: " + getValue);
      result = atomicInteger.compareAndSet(getValue, getValue + 1);
      log("result: " + result);
    } while (!result);

    return getValue + 1;
  }
}
