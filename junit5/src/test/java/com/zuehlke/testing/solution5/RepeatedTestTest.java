package com.zuehlke.testing.solution5;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;

class RepeatedTestTest {

    @RepeatedTest(3)
    void testWithValue() {}

    @DisplayName("value and name")
    @RepeatedTest(value = 4, name = "repetition {currentRepetition} of {totalRepetitions} of test '{displayName}'")
    void testWithValueAndName() {}

    @RepeatedTest(5)
    void testWithRepetitionInfo(RepetitionInfo info) {
        System.out.println("Repetition " + info.getCurrentRepetition() + " of " + info.getTotalRepetitions());
    }
}
