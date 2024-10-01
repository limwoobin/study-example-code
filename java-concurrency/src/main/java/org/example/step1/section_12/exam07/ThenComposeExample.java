package org.example.step1.section_12.exam07;

import java.util.concurrent.CompletableFuture;

public class ThenComposeExample {
  public static void main(String[] args) {
    MyService service = new MyService();
    CompletableFuture<Integer> cf1 = service.getData(5);
    CompletableFuture<Integer> cf2 = cf1.thenCompose(service::getData2);

    int finalResult = cf2.join();
    System.out.println("finalResult = " + finalResult);
  }

  static class MyService {

    public CompletableFuture<Integer> getData(int input) {
      return CompletableFuture.supplyAsync(() -> {
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }

        return input * 2;
      });
    }

    public CompletableFuture<Integer> getData2(int input) {
      return CompletableFuture.supplyAsync(() -> {
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }

        return input * 2;
      });
    }
  }
}
