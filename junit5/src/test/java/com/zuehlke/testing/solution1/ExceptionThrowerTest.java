package com.zuehlke.testing.solution1;

import com.zuehlke.testing.exercise1.ExceptionThrower;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ExceptionThrowerTest {

    private ExceptionThrower testee = new ExceptionThrower();

    @Test
    void testThrowRuntimeException_illegalParameter_illegalArgumentMessage() {
        // act
        RuntimeException exception = assertThrows(RuntimeException.class, () -> testee.throwRuntimeException(-1));

        //assert
        assertThat(exception.getMessage(), startsWith("Illegal argument"));
    }

    @Test
    void testThrowRuntimeException_legalParameter_runtimeMessage() {
        // act
        RuntimeException exception = assertThrows(RuntimeException.class, () -> testee.throwRuntimeException(1));

        //assert
        assertThat(exception.getMessage(), is(equalTo("Runtime exception occurred")));
    }

    @Test
    void testThrowExceptionWithCause_expectCauseType() throws Exception {
        // act
        RuntimeException exception = assertThrows(RuntimeException.class, () -> testee.throwExceptionWithCause());

        //assert
        assertThat(exception.getMessage(), is(equalTo("outer exception")));
        assertThat(exception.getCause(), instanceOf(NullPointerException.class));
        assertThat(exception.getCause().getMessage(), is(equalTo("Oops! Something wasn't supposed to be null here.")));
    }

    @Test
    void testThrowExceptionWithCause_expectCauseWithMessageUsingCustomMatcher() throws Exception {
        // act
        RuntimeException exception = assertThrows(RuntimeException.class, () -> testee.throwExceptionWithCause());

        //assert
        assertThat(exception.getMessage(), is(equalTo("outer exception")));
        assertThat(exception.getCause(), CauseMatcher.matchesCause(NullPointerException.class,
                "Oops! Something wasn't supposed to be null here."));
    }

    private static class CauseMatcher extends TypeSafeMatcher<Throwable> {

        private final Class<? extends Throwable> type;
        private final String expectedMessage;

        private CauseMatcher(Class<? extends Throwable> type, String expectedMessage) {
            this.type = type;
            this.expectedMessage = expectedMessage;
        }

        @Override
        protected boolean matchesSafely(Throwable item) {
            return item.getClass().isAssignableFrom(type) && item.getMessage().contains(expectedMessage);
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("expects type ").appendValue(type).appendText(" and a message ")
                    .appendValue(expectedMessage);
        }

        public static CauseMatcher matchesCause(Class<? extends Throwable> type, String expectedMessage) {
            return new CauseMatcher(type, expectedMessage);
        }
    }

}
