package org.example.section_13;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class CustomForkJoinPoolExample {
  public static void main(String[] args) {
    int core = Runtime.getRuntime().availableProcessors();
    int[] array = new int[10];
    for (int i = 0; i < array.length; i++) {
      array[i] = i;
    }

    ForkJoinPool pool = new ForkJoinPool(core);
    RecursiveTask<Integer> task = new CustomRecursiveTask(array, 0, array.length);
    int result = pool.invoke(task);

    System.out.println("result = " + result);
  }
}
