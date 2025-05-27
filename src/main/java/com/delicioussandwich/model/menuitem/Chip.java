package com.delicioussandwich.model.menuitem;

import com.delicioussandwich.model.abstractclass.MenuItem;

public class Chip extends MenuItem {
    private static final double CHIP_PRICE = 1.50;


    public Chip(String flavor) {
        super(flavor + " Chips", CHIP_PRICE);
    }

    @Override
    public String toString(){
        return "Chips: " + getName() + " - $" +String.format("%.2f", getPrice());
    }
}
