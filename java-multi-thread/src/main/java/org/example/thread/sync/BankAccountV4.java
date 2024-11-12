package org.example.thread.sync;

import org.example.util.ThreadUtils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static org.example.util.MyLogger.log;

public class BankAccountV4 implements BankAccount {
  private int balance;
  private final Lock lock = new ReentrantLock();;

  public BankAccountV4(int initialBalance) {
    this.balance = initialBalance;
  }

  @Override
  public boolean withdraw(int amount) {
    log("거래 시작: " + getClass().getSimpleName());
    log("[검증 시작] 출금액: " + amount + ", 잔액: " + balance);

    lock.lock();

    try {
      if (balance < amount) {
        log("[검증 실패] 출금액: " + amount + ", 잔액: " + balance);
        return false;
      }

      log("[검증 완료] 출금액: " + amount + ", 잔액: " + balance);
      ThreadUtils.sleep(1000);
      this.balance -= amount;
      log("[출금 완료] 출금액: " + amount + ", 잔액: " + balance);
    } finally {
      lock.unlock();
    }

    log("거래 종료");
    return true;
  }

  @Override
  public synchronized int getBalance() {
    lock.lock();
    try {
      return balance;
    } finally {
      lock.unlock();
    }
  }
}
