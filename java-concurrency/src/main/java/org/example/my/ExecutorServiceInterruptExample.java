package org.example.my;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceInterruptExample {
  public static void main(String[] args) {
    ExecutorService executor = Executors.newSingleThreadExecutor();
    Future<?> future = executor.submit(() -> {
      try {
        Thread.sleep(5000); // Simulate long-running task
      } catch (InterruptedException e) {
        System.out.println("Task was interrupted by ExecutorService.");
      }
    });

    try {
      Thread.sleep(1000);
      executor.shutdownNow(); // Interrupts the running task
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }

}
