package com.zuehlke.testing;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Person {

    @Id
    private long id;
    private String firstName;
    private String lastName;

    Person() {}
    
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
