package org.example.section_08.exam03;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockExample {
  public static void main(String[] args) {
    ReadWriteLock lock = new ReentrantReadWriteLock();
    SharedData sharedData = new SharedData();

    Thread reader = new Thread(() -> {
      lock.readLock().lock();
      try {
        System.out.println("읽기 스레드1 가 데이터를 읽고 있습니다. data: " + sharedData.getData());
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      } finally {
        lock.readLock().unlock();
      }
    });

    Thread reader2 = new Thread(() -> {
      lock.readLock().lock();
      try {
        System.out.println("읽기 스레드2 가 데이터를 읽고 있습니다. data: " + sharedData.getData());
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      } finally {
        lock.readLock().unlock();
      }
    });

    Thread writer = new Thread(() -> {
      lock.writeLock().lock();
      try {
        System.out.println("쓰기 스레드가 데이터를 쓰고 있습니다.");
        sharedData.setData(40);
        Thread.sleep(2000);
        System.out.println("쓰기 스레드가 데이터를 변경 했습니다. data: " + sharedData.getData());
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      } finally {
        lock.writeLock().unlock();
      }
    });

    reader.start();
    reader2.start();
    writer.start();
  }

  static class SharedData {
    private int data = 0;

    public int getData() {
      return data;
    }

    public void setData(int data) {
      this.data = data;
    }
  }
}
