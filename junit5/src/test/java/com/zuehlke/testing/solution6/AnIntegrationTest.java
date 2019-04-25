package com.zuehlke.testing.solution6;

import org.junit.jupiter.api.Test;

@IntegrationTest
class AnIntegrationTest {

    @Test
    void testIntegration() throws InterruptedException {
        //some long running test (5 Minutes)
        Thread.sleep(5*60*1000000);
    }
}
