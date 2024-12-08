package org.example.thread.cas.spinlock;

import org.example.util.ThreadUtils;

import static org.example.util.MyLogger.log;

public class SpinLockBad {

  private volatile boolean lock = false;

  public void lock() {
    log("락 획득 시도");;
    while (true) {
      if (!lock) { // 1. 락 사용 여부 확인
        ThreadUtils.sleep(100); // 문제 상황 확인용, 스레드 대기
        lock = true; // 2. 락의 값 변경
        break;
      } else {
        // 락을 획득할때까지 스핀 대기
        log("락 획득 실패 - 스핀 대기");
      }
    }

    log("락 획득 완료");
  }

  public void unlock() {
    lock = false;
    log("락 반납 완료");
  }
}
