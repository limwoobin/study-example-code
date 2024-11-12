package org.example.thread.sync;

import org.example.util.ThreadUtils;

import static org.example.util.MyLogger.log;

public class BankAccountV2 implements BankAccount {
  private int balance;

  public BankAccountV2(int initialBalance) {
    this.balance = initialBalance;
  }

  @Override
  public synchronized boolean withdraw(int amount) {
    log("거래 시작: " + getClass().getSimpleName());
    log("[검증 시작] 출금액: " + amount + ", 잔액: " + balance);

    if (balance < amount) {
      log("[검증 실패] 출금액: " + amount + ", 잔액: " + balance);
      return false;
    }

    log("[검증 완료] 출금액: " + amount + ", 잔액: " + balance);
    ThreadUtils.sleep(1000);
    this.balance -= amount;
    log("[출금 완료] 출금액: " + amount + ", 잔액: " + balance);
    log("거래 종료");
    return true;
  }

  @Override
  public synchronized int getBalance() {
    return balance;
  }
}
