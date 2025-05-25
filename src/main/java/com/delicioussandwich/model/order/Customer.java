package com.delicioussandwich.model.order;

public class Customer {
    //Properties
    private String name;
    private String phoneNumber;

    //Constructor
    public Customer(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    //Getters and Setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString(){
        return name + " (" + phoneNumber + ")";
    }
}
