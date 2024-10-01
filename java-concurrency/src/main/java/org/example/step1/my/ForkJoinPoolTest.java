package org.example.step1.my;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolTest {
  public static void main(String[] args) {
    List<String> list = List.of("a", "b", "c", "d");
    list.parallelStream()
      .forEach(it -> System.out.println(Thread.currentThread().getName() + ", " + it));

    ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
    try {
      pool.submit(() -> {
        list.parallelStream().forEach(it -> {
          System.out.println(Thread.currentThread().getName() + ", " + it);
        });
      }).get();
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } catch (ExecutionException e) {
      throw new RuntimeException(e);
    }


    pool.shutdown();
  }
}
