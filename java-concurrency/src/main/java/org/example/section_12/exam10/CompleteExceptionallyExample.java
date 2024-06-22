package org.example.section_12.exam10;

import java.util.concurrent.CompletableFuture;

public class CompleteExceptionallyExample {
  public static void main(String[] args) {
    CompletableFuture<String> cf = new CompletableFuture<>();
    getData(cf);
    cf.thenApply(value -> {
      System.out.println(value);
      return value.toUpperCase();
    }).handle((result, ex) -> {
      if (ex != null) {
        System.out.println("ex = " + ex.getMessage());
        return "noname";
      }

      System.out.println("result = " + result);
      return result;
    });
  }

  static void getData(CompletableFuture<String> cf) {
    try {
      System.out.println("비동기 작업 수행 중..");
      Thread.sleep(500);
      throw new IllegalArgumentException("error");
    } catch (Exception e) {
      cf.completeExceptionally(e);
    }

    cf.complete("hi");
  }
}
