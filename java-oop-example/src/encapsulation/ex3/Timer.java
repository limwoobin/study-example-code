package encapsulation.ex3;

import java.util.concurrent.TimeUnit;

public class Timer {
    // as-is
//    public long startTime;
//    public long stopTime;

    // to-be
    private long startTime;
    private long stopTime;

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.stopTime = System.currentTimeMillis();
    }

    public long elapsedTime(TimeUnit unit) {
        return stopTime - startTime;
    }
}
