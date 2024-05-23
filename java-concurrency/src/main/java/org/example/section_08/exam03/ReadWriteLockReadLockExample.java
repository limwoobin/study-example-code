package org.example.section_08.exam03;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockReadLockExample {
  public static void main(String[] args) {
    ReadWriteLock lock = new ReentrantReadWriteLock();
    BankAccount account = new BankAccount(lock);

    for (int i = 0; i < 10; i++) {
      new Thread(() -> {
        int balance = account.getBalance();
        System.out.println(Thread.currentThread().getName() + "- 현재 잔액: " + balance);
      }).start();
    }

    for (int i = 0; i < 2; i++) {
      new Thread(() -> {
        int depositAmount = (int) (Math.random() * 1000);
        account.deposit(depositAmount);
        System.out.println(Thread.currentThread().getName() + "- 현재 잔액: " + depositAmount);
      }).start();
    }

    for (int i = 0; i < 10; i++) {
      new Thread(() -> {
        int balance = account.getBalance();
        System.out.println(Thread.currentThread().getName() + "- 현재 잔액: " + balance);
      }).start();
    }
  }
}
