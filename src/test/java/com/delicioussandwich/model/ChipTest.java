package com.delicioussandwich.model;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * Chips unit test
 */
public class ChipTest {
    @Test
    public void chipNameTest (){
        Chip chip = new Chip("BBQ Lays", 1.25);
        assertEquals("BBQ Lays", chip.getName());
    }

    @Test
    public void chipPriceTest (){
        Chip chip = new Chip("BBQ Lays", 1.25);
        assertEquals(1.25, chip.getPrice(), 0.001);
    }

}
