package com.zuehlke.testing.solution1;

import com.zuehlke.testing.exercise1.LongRunningProcess;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class LongRunningProcessTest {

    @Test
    void testRun_withoutTimeout() {
        String result = Assertions.assertTimeout(Duration.ofMillis(200), LongRunningProcess::run);
        assertEquals("Hello World", result);
    }
    @Test
    void testRun_waitForTimeout() {
        String result = assertTimeout(Duration.ofMillis(10), LongRunningProcess::run);
        assertEquals("Hello World", result);
    }

    @Test
    void testRun_abortAtTimeout() {
        String result = assertTimeoutPreemptively(Duration.ofMillis(10), LongRunningProcess::run);
        assertEquals("Hello World", result);
    }
}