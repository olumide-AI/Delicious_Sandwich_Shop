package com.delicioussandwich.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {
    @Test
    public void testOrderItem(){
        //Act
        Order order = new Order();

        //Arrange
        order.addItem(new Sandwich("4", "white", true));
        order.addItem(new Chip("Honey BBQ"));
        order.addItem(new Drink("fanta", "small"));

        //Assert
        assertEquals(3, order.getItems().size());
    }

    @Test
    public void testOrderTotalPrice(){
        //Act
        Order order = new Order();

        //Arrange
        order.addItem(new Sandwich("4", "white", true));
        order.addItem(new Chip("Honey BBQ"));
        order.addItem(new Drink("fanta", "small"));

        //Assert
        assertEquals(9.0, order.calcTotal(), 0.001);
    }

    @Test
    public void testCustomerOrder(){
        //Act
        Order order = new Order();
        Customer customer = new Customer("Olumide Kolawole", "321-345-456");

        //Arrange
        order.setCustomer(customer);

        //Assert
        assertEquals("Olumide Kolawole", order.getCustomer().getName());
        assertEquals("321-345-456", order.getCustomer().getPhoneNumber());
    }
}
