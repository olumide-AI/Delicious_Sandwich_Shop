package com.delicioussandwich.model;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SandwichTest {
    @Test
    public void basicSandwichGetNameTest(){
        //Arrange
        Sandwich sandwich = new Sandwich("4", "white", false);

        //Act and Asset
        assertEquals("4\"white sandwich.", sandwich.getName());

    }

    @Test
    public void basicSandwichGetPriceTest(){
        //Arrange
        Sandwich sandwich = new Sandwich("4", "white", false);

        //Act and Asset
        assertEquals(5.50, sandwich.getPrice(), 0.001);

    }

    @Test
    public void basicSandwichGetToppingSizeTest(){
        //Arrange
        Sandwich sandwich = new Sandwich("4", "white", false);

        //Act and Asset
        assertEquals(0, sandwich.getToppingList().size());

    }
    @Test
    public void basicSandwichWithRegularToppingTest(){
        //Arrange
        Sandwich sandwich = new Sandwich("4", "white", false);
        sandwich.addTopping(new RegularTopping("Avocado"));

        //Act
        double sandwichPrice = sandwich.getPrice();

        //Assert
        assertEquals(5.50, sandwichPrice, 0.001);
    }
    @Test
    public void basicSandwichWithPremiumToppingTest(){
        //Arrange
        Sandwich sandwich = new Sandwich("4", "white", false);
        sandwich.addTopping(new PremiumTopping("Beef", "meat", true));

        //Act
        double sandwichPrice = sandwich.getPrice();

        //Assert
        assertEquals(7.0, sandwichPrice, 0.001);
    }

    @Test
    public void basicSandwichWithExtraPremiumToppingTest(){
        //Arrange
        Sandwich sandwich = new Sandwich("4", "white", false);
        sandwich.addTopping(new PremiumTopping("Steak", "meat", true));

        //Act
        double sandwichPrice = sandwich.getPrice();

        //Assert
        assertEquals(7.00, sandwichPrice, 0.001);
        assertEquals(1, sandwich.getToppingList().size());
    }
    @Test
    public void testAddToppingUpdatesPrice() {
        Sandwich sandwich = new Sandwich("8", "wheat", true);
        sandwich.addTopping(new RegularTopping("lettuce"));
        sandwich.addTopping(new PremiumTopping(" provolone cheese", "cheese", true));

        assertEquals(2, sandwich.getToppingList().size());
        assertEquals(9.10, sandwich.getPrice());
    }

    @Test
    public void testRemoveToppingByName() {
        Sandwich sandwich = new Sandwich("12", "sourdough", false);
        sandwich.addTopping(new RegularTopping("lettuce"));
        sandwich.addTopping(new PremiumTopping("provolone cheese", "cheese",true));

        sandwich.removeTopping("lettuce");

        assertEquals(1, sandwich.getToppingList().size());
        assertEquals("Extra Premium provolone cheese", sandwich.getToppingList().get(0).getName());
        assertEquals(11.65, sandwich.getPrice());
    }
}
