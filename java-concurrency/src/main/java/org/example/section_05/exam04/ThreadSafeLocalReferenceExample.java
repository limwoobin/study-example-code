package org.example.section_05.exam04;

public class ThreadSafeLocalReferenceExample {

  class LocalObject {
    private int value;

    public void increment() {
      value++;
    }

    @Override
    public String toString() {
      return "LocalObject{" +
        "value=" + value +
        '}';
    }
  }

  public void useLocalObject() {
    LocalObject localObject = new LocalObject();

    for (int i = 0; i < 5; i++) {
      localObject.increment();
      System.out.println(Thread.currentThread().getName() + " - " + localObject);
      try {
        Thread.sleep(50);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

  public static void main(String[] args) {
    ThreadSafeLocalReferenceExample example = new ThreadSafeLocalReferenceExample();

    Thread thread = new Thread(example::useLocalObject);
    Thread thread2 = new Thread(example::useLocalObject);

    thread.start();
    thread2.start();
  }
}
