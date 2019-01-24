package com.zuehlke.testing.exercise1;

public class LongRunningProcess {

    public static String run() throws InterruptedException {
        Thread.sleep(100);
        return "Hello World";
    }
}
