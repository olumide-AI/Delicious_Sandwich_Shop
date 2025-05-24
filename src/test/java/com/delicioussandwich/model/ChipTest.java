package com.delicioussandwich.model;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * Chips unit test
 */
public class ChipTest {
    @Test
    public void chipNameTest (){
        Chip chip = new Chip("BBQ");
        assertEquals("BBQ Chips", chip.getName());
    }

    @Test
    public void chipPriceTest (){
        Chip chip = new Chip("Vinegar");
        assertEquals(1.50, chip.getPrice(), 0.001);
    }

}
