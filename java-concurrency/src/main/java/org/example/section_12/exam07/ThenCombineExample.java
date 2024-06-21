package org.example.section_12.exam07;

import java.util.concurrent.CompletableFuture;

public class ThenCombineExample {
  public static void main(String[] args) {
    MyService service = new MyService();

    CompletableFuture<String> cf1 = service.getData();
    CompletableFuture<String> cf2 = service.getData2();

    CompletableFuture<String> cf3 = cf1.thenCombine(cf2, (value1, value2) -> value1 + value2);
    CompletableFuture<String> cf4 = cf3.thenCompose(value -> CompletableFuture.supplyAsync(() -> value + " Java"));

    System.out.println(cf4.join());
  }

  static class MyService {
    public CompletableFuture<String> getData() {
      return CompletableFuture.supplyAsync(() -> {
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }

        return "Hello ";
      });
    }

    public CompletableFuture<String> getData2() {
      return CompletableFuture.supplyAsync(() -> {
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }

        return "World";
      });
    }
  }
}
