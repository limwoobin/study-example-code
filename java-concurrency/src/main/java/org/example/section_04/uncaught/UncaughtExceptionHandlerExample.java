package org.example.section_04.uncaught;

public class UncaughtExceptionHandlerExample {
  public static void main(String[] args) {
    Thread thread = new Thread(() -> {
      System.out.println("스레드1 시작");
      throw new RuntimeException("예기치 않은 얘외 발생");
    });

    thread.setUncaughtExceptionHandler((t, e) -> {
      System.out.println(t.getName() + "에서 예외 발생: " + e);
    });

    Thread thread2 = new Thread(() -> {
      System.out.println("스레드2 시작");
      throw new RuntimeException("예기치 않은 얘외 발생");
    });

    thread2.setUncaughtExceptionHandler((t, e) -> {
      System.out.println(t.getName() + "에서 예외 발생: " + e);
    });

    thread.start();
    thread2.start();
  }
}
