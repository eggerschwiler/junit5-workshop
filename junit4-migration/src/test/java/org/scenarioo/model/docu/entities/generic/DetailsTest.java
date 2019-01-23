package org.scenarioo.model.docu.entities.generic;

import org.junit.Test;

import static org.junit.Assert.*;

public class DetailsTest {

    private Details testee = new Details();

    @Test
    public void whenDetailIsAdded_itCanBeRetrieved() {
        //act
        testee.addDetail("DetailKey", "DetailValue");
        //assert
        assertEquals("value not found","DetailValue", testee.getDetail("DetailKey"));
    }

    @Test
    public void whenDetailIsAdded_DetailsIsNotEmpty() {
        //act
        testee.addDetail("DetailKey", "DetailValue");
        //assert
        assertFalse("Details is empty",testee.isEmpty());
    }

}