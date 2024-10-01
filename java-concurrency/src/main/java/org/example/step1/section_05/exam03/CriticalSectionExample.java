package org.example.step1.section_05.exam03;

public class CriticalSectionExample {
  public static void main(String[] args) throws InterruptedException {
    SharedResource resource = new SharedResource();
    Thread thread = new Thread(resource::increment);
    Thread thread2 = new Thread(resource::increment);

    thread.start();
    thread2.start();

//    thread.join();
//    thread2.join();
//
//    System.out.println("counter: " + resource.getCounter());
  }
}

class SharedResource {
  private int counter = 0;

  public void increment() {
//    int counter = 0;

    for (int i = 0; i < 100000; i++) {
      synchronized (this) { // Entry Section
        // Critical Section
        counter++;
        System.out.println(Thread.currentThread().getName() + ": " + counter);
      }// Exit Section
    }

    // Remainder Section
    doOtherWork();
  }

  private void doOtherWork() {
    System.out.println(Thread.currentThread().getName() + " 는 critical section 외부에서 작업을 수행하고 있다");
  }

  public int getCounter() {
    return counter;
  }
}