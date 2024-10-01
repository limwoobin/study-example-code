package org.example.step1.section_12.exam01;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    int finalResult = CompletableFuture.supplyAsync(() -> {
      System.out.println("Service 1 시작");
      return 1;

    }).thenApplyAsync(result -> {
      System.out.println("Service 2 시작");
      return result + 2;

    }).thenApplyAsync(result -> {
      System.out.println("Service 3 시작");
      return result * 3;

    }).thenApplyAsync(result -> {
      System.out.println("Service 4 시작");
      return result - 4;

    }).thenApplyAsync(result -> {
      System.out.println("Service 5 시작");
      return result + 5;
    }).get();

    System.out.println("finalResult = " + finalResult);
  }
}
