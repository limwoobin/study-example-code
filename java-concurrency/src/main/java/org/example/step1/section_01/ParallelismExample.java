package org.example.step1.section_01;

import java.util.ArrayList;
import java.util.List;

public class ParallelismExample {
  public static void main(String[] args) {
    int cpuCores = Runtime.getRuntime().availableProcessors();

    List<Integer> data = new ArrayList<>();
    for (int i = 0; i < cpuCores; i++) {
      data.add(i);
    }

    long startTime = System.currentTimeMillis();

    long sum = data.parallelStream()
      .mapToLong(i -> {
        try {
          Thread.sleep(500);
        } catch (InterruptedException e) {
          try {
            throw e;
          } catch (InterruptedException ex) {
            throw new RuntimeException(ex);
          }
        }
        System.out.println(i * i);
        return (long) i * i;
      }).sum();

    long endTime = System.currentTimeMillis();

    System.out.println("CPU 개수만큼 데이터를 병렬로 처리하는 데 걸린 시간: " + (endTime - startTime) + "ms");
    System.out.println("결과1: " + sum);
  }
}
