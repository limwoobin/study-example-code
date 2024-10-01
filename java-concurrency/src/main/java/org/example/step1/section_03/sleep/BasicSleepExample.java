package org.example.step1.section_03.sleep;

public class BasicSleepExample {
  public static void main(String[] args) {
    try {
      System.out.println("2초 후에 메시지가 출력됩니다");
      Thread.sleep(2000);
      System.out.println("Hello world");
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }
}
