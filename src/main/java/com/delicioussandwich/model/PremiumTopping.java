package com.delicioussandwich.model;

public class PremiumTopping extends Topping{

    public PremiumTopping(String name) {
        super(name);
    }

    @Override
    public double getPrice(String sandwichSize) {
        return 0;
    }
}
