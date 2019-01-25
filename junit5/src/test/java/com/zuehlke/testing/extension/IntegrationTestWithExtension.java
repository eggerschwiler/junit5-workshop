package com.zuehlke.testing.extension;

import com.zuehlke.testing.Person;
import com.zuehlke.testing.PersonDao;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

@ExtendWith(PersonResourceExtension.class)
class IntegrationTestWithExtension {

    private PersonDao dao = new PersonDao();

    @Test
    void find_withExtension(PersonResource personResource) {
        // arrange
        Person expected = personResource.createPerson("Smarty");
        // act
        Person result = dao.find(expected.getLastName());
        // assert
        assertThat(result.getLastName(), is(equalTo(expected.getLastName())));
    }
}

