package encapsulation.ex3;

import java.util.concurrent.TimeUnit;

public class Test {
    public static void main(String[] args) {
        // as-is
//        Timer t = new Timer();
//        t.startTime = System.currentTimeMillis();
//        t.stopTime = System.currentTimeMillis();
//        long elapsedTime = t.stopTime = t.startTime;

        // to-be
        Timer t = new Timer();
        t.start();
        t.stop();
        long time = t.elapsedTime(TimeUnit.MILLISECONDS);
    }
}
