package org.example.thread.cas.increment;

public class BasicInteger implements IncrementInteger {
  private int value;

  public BasicInteger() {
    this.value = 0;
  }

  @Override
  public void increment() {
    value++;
  }

  @Override
  public int get() {
    return value;
  }
}
