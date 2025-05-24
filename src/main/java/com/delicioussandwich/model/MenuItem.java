package com.delicioussandwich.model;

/**
 * Abstract and base class for all menu item: sandwich, chips and drinks
 */
public abstract class MenuItem {
    protected String name;
    protected double price;

    //Constructor
    public MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    //To-String Method
    public String toString(){
        return String.format("%s - $%.2f", name, price);
    }
}
