package org.example.section_06.exam01;

public class MutexExample {
  public static void main(String[] args) throws InterruptedException {
    Mutex mutex = new Mutex();
    SharedData sharedData = new SharedData(mutex);

    Thread thread = new Thread(sharedData::sum);
    Thread thread2 = new Thread(sharedData::sum);

    thread.start();
    thread2.start();

    thread.join();
    thread2.join();
    System.out.println("sum: " + sharedData.getSum());
  }
}
