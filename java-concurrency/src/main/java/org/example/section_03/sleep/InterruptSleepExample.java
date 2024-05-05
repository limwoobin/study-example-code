package org.example.section_03.sleep;

public class InterruptSleepExample {
  public static void main(String[] args) throws InterruptedException {
    Thread thread = new Thread(() -> {
      try {
        System.out.println("10 초 동안 잠에 듭니다. 인터럽트 되지 않는다면 계속 잠들어있습니다.");
        Thread.sleep(10000);
        System.out.println("인터럽트 없이 잠에서 깨어났습니다.");
      } catch (InterruptedException e) {
        System.out.println("잠들어 있는 동안 인터럽트 되었습니다");
      }
    });

    thread.start();

    Thread.sleep(1000);
//    thread.interrupt();
  }
}
