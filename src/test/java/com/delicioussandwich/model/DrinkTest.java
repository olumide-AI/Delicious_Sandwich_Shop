package com.delicioussandwich.model;

import com.delicioussandwich.model.menuitem.Drink;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DrinkTest {
    @Test
    public void DrinkNameTest (){
        Drink drink = new Drink("Cocounut water", "small" );
        assertEquals("small Cocounut water", drink.getName());
        assertEquals(2.00, drink.getPrice(), 0.01);
    }

    @Test
    public void DrinkPriceTest (){
        Drink drink = new Drink("Coke", "large");
        assertEquals("large Coke", drink.getName());
        assertEquals(3.00, drink.getPrice(), 0.01);
    }
}
