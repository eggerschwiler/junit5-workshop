package com.zuehlke.testing.extension;

import com.zuehlke.testing.Person;
import com.zuehlke.testing.PersonDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.RegisterExtension;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

class IntegrationTestWithExtension {

    private PersonDao dao = new PersonDao();

    @RegisterExtension
    private PersonResource personResource = new PersonResource();

    @Test
    void find_withRule() {
        // arrange
        Person expected = personResource.createPerson("Smarty");
        // act
        Person result = dao.find(expected.getLastName());
        // assert
        assertThat(result.getLastName(), is(equalTo(expected.getLastName())));
    }
}

