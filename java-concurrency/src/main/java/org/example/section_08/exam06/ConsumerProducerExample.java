package org.example.section_08.exam06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConsumerProducerExample {
  private static int CAPACITY = 5;
  private Queue<Integer> queue = new LinkedList<>();
  private Lock lock = new ReentrantLock();
  private Condition notEmpty = lock.newCondition();
  private Condition notFull = lock.newCondition();

  public void produce() throws InterruptedException {
    int value = 0;
    while (true) {
      lock.lock();
      try {
        while (queue.size() == CAPACITY) {
          System.out.println("큐가 가득차서 대기함");
          notFull.await();
        }
        queue.offer(value);
        System.out.println("생산: " + value + ", 큐 크기: " + queue.size());
        value++;
        notEmpty.signal();
      } finally {
        lock.unlock();
      }
    }
  }

  public void consume() throws InterruptedException {
    while (true) {
      lock.lock();
      try {
        while (queue.isEmpty()) {
          System.out.println("큐가 비어서 대기함");
          notEmpty.await();
        }
        int value = queue.poll();
        System.out.println("생산: " + value + ", 큐 크기: " + queue.size());
        notFull.signal();
      } finally {
        lock.unlock();
      }
    }
  }

  public static void main(String[] args) {
    ConsumerProducerExample example = new ConsumerProducerExample();

    Thread thread = new Thread(() -> {
      try {
        example.produce();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });

    Thread thread2 = new Thread(() -> {
      try {
        example.consume();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    });

    thread.start();
    thread2.start();
  }
}
