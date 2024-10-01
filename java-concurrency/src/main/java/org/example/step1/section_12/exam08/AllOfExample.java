package org.example.step1.section_12.exam08;

import java.util.concurrent.CompletableFuture;

public class AllOfExample {
  public static void main(String[] args) throws InterruptedException {
    ServiceA sa = new ServiceA();
    ServiceA sa2 = new ServiceA();
    ServiceA sa3 = new ServiceA();

    CompletableFuture<Integer> cf1 = sa.getData();
    CompletableFuture<Integer> cf2 = sa.getData2();
    CompletableFuture<Integer> cf3 = sa.getData3();

    CompletableFuture<Void> cf4 = CompletableFuture.allOf(cf1, cf2, cf3);
    CompletableFuture<Integer> finalCf = cf4.thenApply(it -> {
      int result = cf1.join();
      int result2 = cf2.join();
      int result3 = cf3.join();

      System.out.println("result = " + result);
      System.out.println("result2 = " + result2);
      System.out.println("result3 = " + result3);
      return result + result2 + result3;
    });

    Thread.sleep(3000);

    System.out.println("void: " + cf4);

//    System.out.println("finalCf = " + finalCf.join());
    System.out.println("finalCf = " + finalCf);
    System.out.println("메인 스레드 종료");
  }

  static class ServiceA {
    public CompletableFuture<Integer> getData() {
      return CompletableFuture.supplyAsync(() -> {
        try {
          Thread.sleep(1000);
          System.out.println("비동기 작업 시작 1");
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }

        return 10;
      });
    }

    public CompletableFuture<Integer> getData2() {
      return CompletableFuture.supplyAsync(() -> {
        try {
          Thread.sleep(2000);
          System.out.println("비동기 작업 시작 2");
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }

        return 20;
      });
    }

    public CompletableFuture<Integer> getData3() {
      return CompletableFuture.supplyAsync(() -> {
        try {
          Thread.sleep(3000);
          System.out.println("비동기 작업 시작 3");
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }

        return 30;
      });
    }
  }
}
