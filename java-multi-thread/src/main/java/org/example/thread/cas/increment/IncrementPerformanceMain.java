package org.example.thread.cas.increment;

public class IncrementPerformanceMain {
  public static final long COUNT = 100_000_000;

  public static void main(String[] args) {
    test(new BasicInteger());
    test(new VolatileInteger());
    test(new SyncInteger());
    test(new MyAtomicInteger());
  }

  static void test(IncrementInteger incrementInteger) {
    long startMs = System.currentTimeMillis();
    for (long i = 0; i < COUNT; i++) {
      incrementInteger.increment();
    }

    long endMs = System.currentTimeMillis();
    System.out.println(incrementInteger.getClass().getSimpleName() + ": ms=" + (endMs - startMs));
  }
}
