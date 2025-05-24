package com.delicioussandwich.model;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class ToppingTest {
    @Test
    public void testRegularToppingIsZero(){
        //Arrange - Create new topping
        Topping topping = new RegularTopping("Spinach");
        //Act and Assert
        assertEquals(0.0, topping.getPrice("4"), 0.001);
        assertEquals(0.0, topping.getPrice("8"), 0.001);
        assertEquals(0.0, topping.getPrice("12"), 0.001);

    }
    @Test
    public void testPremiumToppingWithNormalPrice(){
        //Arrange - Create new Topping
        Topping topping = new PremiumTopping("Turkey", false);
        //Act and Assert
        assertEquals(1.0, topping.getPrice("4"), 0.001);
        assertEquals(2.0, topping.getPrice("8") , 0.001);
        assertEquals(3.0, topping.getPrice("12") , 0.001);
    }

    @Test
    public void testPremiumToppingWithExtraTopping(){
        //Arrange - Create new Topping
        Topping topping = new PremiumTopping("Turkey", true);
        //Act and Assert
        assertEquals(1.50, topping.getPrice("4"), 0.001);
        assertEquals(3.0, topping.getPrice("8"), 0.001);
        assertEquals(4.50, topping.getPrice("12"), 0.001);
    }
}
