package org.example.thread.sync;

import static org.example.util.MyLogger.log;

public class BankMain {
  public static void main(String[] args) throws InterruptedException {
//    BankAccount account = new BankAccountV1(1000);
//    BankAccount account = new BankAccountV2(1000);
//    BankAccount account = new BankAccountV3(1000);
//    BankAccount account = new BankAccountV4(1000);
//    BankAccount account = new BankAccountV5(1000);
    BankAccount account = new BankAccountV6(1000);

    Thread t1 = new Thread(new WithdrawTask(account, 800), "t1");
    Thread t2 = new Thread(new WithdrawTask(account, 800), "t2");
    t1.start();
    t2.start();

    Thread.sleep(500);
    log(t1.getName() + ", 상태: " + t1.getState());
    log(t2.getName() + ", 상태: " + t2.getState());

    t1.join();
    t2.join();
    log("최종 잔액: " + account.getBalance());
  }
}
