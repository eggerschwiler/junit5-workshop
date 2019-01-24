package com.zuehlke.testing.solution1;

import com.zuehlke.testing.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PersonTest {

    @Test
    void testPerson() {
        Person person = new Person("Hans", "Meier");
        assertEquals("Hans", person.getFirstName(), "first Name");
        assertEquals("Meier", person.getLastName(), "last Name");
    }
}
