package org.example.step1.section_12.exam11;

import java.util.concurrent.CompletableFuture;

public class WaitingJoinExample {
  public static void main(String[] args) {
    CompletableFuture<Void> cf = CompletableFuture.supplyAsync(() -> {
      sleep(100);
      System.out.println("비동기 시작");
      return 1;
    }).thenApplyAsync(value -> {
      sleep(100);
      System.out.println("비동기 실행 1");
      return value + 2;
    }).thenApplyAsync(value -> {
      sleep(100);
      System.out.println("비동기 실행 2");
      return value + 3;
    }).thenAcceptAsync(value -> {
      sleep(100);
      System.out.println("최종 결과: " + value);
    });

//    sleep(1000);
    cf.join();
    System.out.println("Main Thread 종료");
  }

  private static void sleep(int time) {
    try {
      Thread.sleep(time);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
