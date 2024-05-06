package org.example.section_04.thread_group;

public class NestedThreadGroupExample {
  public static void main(String[] args) throws InterruptedException {
    ThreadGroup topGroup = new ThreadGroup("최상위 스레드 그룹");
    ThreadGroup subGroup = new ThreadGroup(topGroup, "하위 스레드 그룹");

    Thread topGroupThread = new Thread(topGroup, new GroupRunnable(), "TopGroupThread");
    Thread subGroupThread = new Thread(subGroup, new GroupRunnable(), "SubGroupThread");

    topGroupThread.start();
    subGroupThread.start();

    Thread.sleep(1000);
    System.out.println("---------------------------");
    System.out.println("최상위 스레드 그룹의 정보");
    topGroup.list();
  }

  static class GroupRunnable implements Runnable {

    @Override
    public void run() {
      Thread currentThread = Thread.currentThread();
      System.out.println(currentThread.getName() + " 는 " + currentThread.getThreadGroup().getName() + " 에 속한다");
    }
  }
}
