package org.example.step1.section_06.exam02;

public class CountingSemaphoreExample {
  public static void main(String[] args) throws InterruptedException {
    int permits = 10;
    CommonSemaphore semaphore = new CountingSemaphore(permits);
    SharedResource resource = new SharedResource(semaphore);

    int threadCount = 10;
    Thread[] threads = new Thread[threadCount];
    for (int i = 0; i < threadCount; i++) {
      threads[i] = new Thread(resource::sum);
      threads[i].start();
    }

    for (int i = 0; i < threadCount; i++) {
      threads[i].join();
    }

    System.out.println("sum: " + resource.getSum());
  }
}
