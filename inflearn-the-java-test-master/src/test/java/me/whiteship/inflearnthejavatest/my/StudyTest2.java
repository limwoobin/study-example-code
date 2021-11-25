package me.whiteship.inflearnthejavatest.my;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(FindSlowTestExtension.class)
public class StudyTest2 {

    @Test
    void create_test() throws InterruptedException {
        Thread.sleep(1005);
        System.out.println("SlowTest");
    }
}
