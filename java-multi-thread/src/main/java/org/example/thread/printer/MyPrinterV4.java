package org.example.thread.printer;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

import static org.example.util.MyLogger.log;

public class MyPrinterV4 {
  public static void main(String[] args) {
    Printer printer = new Printer();
    Thread printerThread = new Thread(printer, "printer");
    printerThread.start();

    Scanner userInput = new Scanner(System.in);
    while (true) {
      log("프린터할 문서를 입력하세요. 종료(q)");
      String input = userInput.nextLine();
      if ("q".equals(input)) {
        printerThread.interrupt();
        break;
      }

      printer.addJob(input);
    }
  }

  static class Printer implements Runnable {
    Queue<String> jobQueue = new ConcurrentLinkedQueue<>();

    @Override
    public void run() {
      while (!Thread.interrupted()) {
        if (jobQueue.isEmpty())  {
          Thread.yield();
          continue;
        }

        try {
          String job = jobQueue.poll();
          log("출력 시작: " + job + ", 대기 문서: " + jobQueue);
          Thread.sleep(3000);
          log("출력 완료");
        } catch (InterruptedException e) {
          log("인터럽트!");
          break;
        }
      }
    }

    public void addJob(String input) {
      jobQueue.offer(input);
    }
  }
}
