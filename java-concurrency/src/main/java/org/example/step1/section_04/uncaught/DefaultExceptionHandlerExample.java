package org.example.step1.section_04.uncaught;

public class DefaultExceptionHandlerExample {
  public static void main(String[] args) {
    Thread.setDefaultUncaughtExceptionHandler((t, e) -> {
      System.out.println(t.getName() + "에서 예외 발생: " + e);
    });

    Thread thread = new Thread(() -> {
      throw new RuntimeException("스레드1 예외 발생");
    });

    Thread thread2 = new Thread(() -> {
      throw new RuntimeException("스레드2 예외 발생");
    });

    thread.start();
    thread2.start();
  }
}
