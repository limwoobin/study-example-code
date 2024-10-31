package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class Main {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    System.out.println("Hello world!");
    ForkJoinPool pool = new ForkJoinPool(5);

    List<String> list = Arrays.asList("a", "b", "c", "d", "e");

    pool.submit(() -> list.parallelStream().forEach(it -> System.out.println(it + "," +  Thread.currentThread().getName()))).get();
    pool.shutdown();
  }
}