package org.example.section_12.exam04;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class SupplyAsyncExample {
  public static void main(String[] args) {
    MyService service = new MyService();

    CompletableFuture<List<Integer>> cf = CompletableFuture.supplyAsync(() -> {
      System.out.println(Thread.currentThread().getName() + " 가 비동기 작업을 시작합니다.");
      return service.getData();
    });

    List<Integer> result = cf.join();
    result.forEach(System.out::println);
  }
}

class MyService {

  public List<Integer> getData() {
    try {
      Thread.sleep(1000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }

    return List.of(1, 2, 3, 4, 5);
  }
}