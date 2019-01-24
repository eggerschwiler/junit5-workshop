package org.scenarioo.model.docu.entities.generic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DetailsTest {

    private Details testee = new Details();

    @Test
    void whenDetailIsAdded_itCanBeRetrieved() {
        //act
        testee.addDetail("DetailKey", "DetailValue");
        //assert
        assertEquals("DetailValue", testee.getDetail("DetailKey"), "value not found");
    }

    @Test
    void whenDetailIsAdded_DetailsIsNotEmpty() {
        //act
        testee.addDetail("DetailKey", "DetailValue");
        //assert
        assertFalse(testee.isEmpty(), "Details is empty");
    }

}