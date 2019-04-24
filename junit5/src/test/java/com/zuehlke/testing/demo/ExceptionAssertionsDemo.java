package com.zuehlke.testing.demo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExceptionAssertionsDemo {

    @Test
    void assertExceptionIsThrown() {
        assertThrows(IllegalArgumentException.class, ExceptionAssertionsDemo::doSomething);
    }

    @Test
    void assertExceptionMessage() {
        Throwable exception = assertThrows(IllegalArgumentException.class, ExceptionAssertionsDemo::doSomething);
        assertEquals("a message", exception.getMessage());
    }

    private static void doSomething() {
        throw new IllegalArgumentException("a message");
    }
}
