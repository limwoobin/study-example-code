package org.example.section_04.uncaught;

public class ThreadExceptionExample {
  public static void main(String[] args) {
    try {
      new Thread(() -> {
        throw new RuntimeException("스레드 예외 발생");
      }).start();
    } catch (Exception e) {
      notify(e);
    }
  }

  private static void notify(Exception e) {
    System.out.println("관리자에게 알림: " + e);
  }
}
