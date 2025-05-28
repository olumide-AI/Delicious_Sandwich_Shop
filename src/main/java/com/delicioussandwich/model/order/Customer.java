package com.delicioussandwich.model.order;
/**
 * Represents a customer placing an order, identified by name and phone number.
 */

public class Customer {
    //Properties
    private final String name;
    private final String phoneNumber;

    //Constructor
    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    //Getters and Setter
    public String getName() {
        return name;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString(){
        return name + " (" + phoneNumber + ")";
    }
}
