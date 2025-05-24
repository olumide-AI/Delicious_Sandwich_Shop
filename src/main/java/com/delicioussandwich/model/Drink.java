package com.delicioussandwich.model;

public class Drink extends MenuItem{
    public Drink(String name, double price) {
        super(name, price);
    }

    @Override
    public String toString() {
        return "Drink: " + super.toString();
    }
}
