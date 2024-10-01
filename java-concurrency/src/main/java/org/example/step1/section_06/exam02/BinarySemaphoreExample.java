package org.example.step1.section_06.exam02;

public class BinarySemaphoreExample {
  public static void main(String[] args) throws InterruptedException {
    CommonSemaphore semaphore = new BinarySemaphore();
    SharedResource sharedResource = new SharedResource(semaphore);

    Thread thread = new Thread(sharedResource::sum);
    Thread thread2 = new Thread(sharedResource::sum);

    thread.start();
    thread2.start();

    thread.join();
    thread2.join();
    System.out.println("sum: " + sharedResource.getSum());
  }
}
