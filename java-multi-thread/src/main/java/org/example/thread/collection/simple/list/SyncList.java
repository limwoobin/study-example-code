package org.example.thread.collection.simple.list;

import org.example.util.ThreadUtils;

import java.util.Arrays;

public class SyncList implements SimpleList {
  private static final int DEFAULT_CAPACITY = 5;

  private Object[] elementData;
  private int size = 0;

  public SyncList() {
    this.elementData = new Object[DEFAULT_CAPACITY];
  }

  @Override
  public synchronized void add(Object o) {
    elementData[size] = o;
    ThreadUtils.sleep(100);
    size++;
  }

  @Override
  public synchronized int size() {
    return size;
  }

  @Override
  public synchronized Object get(int index) {
    return elementData[index];
  }

  @Override
  public String toString() {
    return Arrays.toString(Arrays.copyOf(elementData, size)) +
      " size= " + size + ", capacity= " + elementData.length;
  }
}
