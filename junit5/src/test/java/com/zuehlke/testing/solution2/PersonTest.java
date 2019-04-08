package com.zuehlke.testing.solution2;

import com.zuehlke.testing.Person;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(LogTestExecutionExtension.class)
class PersonTest {

    @Test
    void testPerson_firstNameGiven() {
        Person person = new Person("Hans", "Meier");
        assertEquals("Hans", person.getFirstName(), "first Name");
        assertEquals("Meier", person.getLastName(), "last Name");
    }

    @Test
    void testPerson_firstNameEmpty() {
        Person person = new Person("", "Meier");
        assertThat("first name", person.getFirstName(), is(emptyString()));
        assertThat("last name", person.getLastName(), is(equalTo("Meier")));
    }

    @Test
    void testPerson_firstNameNull() {
        Person person = new Person(null, "Meier");
        assertThat("first name", person.getFirstName(), is(nullValue()));
        assertThat("last name", person.getLastName(), is(equalTo("Meier")));
    }
}
