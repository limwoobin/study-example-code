package org.example.step1.my;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

public class ForkJoinPoolTest3 {
  public static void main(String[] args) {
    System.out.println(Runtime.getRuntime().availableProcessors());

    List<String> list = new LinkedList<>();
    list.add("a");
    list.add("b");
    list.add("c");
    list.add("d");

    list.parallelStream()
      .forEach(it -> {
        try {
          Thread.sleep(2000);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + ", " + it);
      });

    ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
    try {
      pool.submit(() -> {
        list.parallelStream().forEach(it -> {
          try {
            Thread.sleep(2000);
          } catch (InterruptedException e) {
            throw new RuntimeException(e);
          }
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
