package com.delicioussandwich.model;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class DrinkTest {
    @Test
    public void DrinkNameTest (){
        Drink drink = new Drink("Large Coke", 1.25);
        assertEquals("BBQ Lays", drink.getName());
    }

    @Test
    public void DrinkPriceTest (){
        Drink drink = new Drink("Large Coke", 1.25);
        assertEquals("Large Coke", drink.getName());
    }
}
