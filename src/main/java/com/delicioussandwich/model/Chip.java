package com.delicioussandwich.model;

public class Chip extends MenuItem{
    public Chip(String name, double price) {
        super(name, price);
    }

    @Override
    public String toString(){
        return "Chips: " + super.toString();
    }
}
