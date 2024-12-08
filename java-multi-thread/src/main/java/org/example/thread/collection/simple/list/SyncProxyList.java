package org.example.thread.collection.simple.list;

public class SyncProxyList implements SimpleList {
  private SimpleList target;

  public SyncProxyList(SimpleList target) {
    this.target = target;
  }

  @Override
  public synchronized void add(Object o) {
    target.add(o);
  }

  @Override
  public synchronized int size() {
    return target.size();
  }

  @Override
  public synchronized Object get(int index) {
    return target.get(index);
  }

  @Override
  public String toString() {
    return target.toString() + " by " + this.getClass().getSimpleName();
  }
}
