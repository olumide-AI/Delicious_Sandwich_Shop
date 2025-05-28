package com.delicioussandwich.model.menuitem;

import com.delicioussandwich.model.abstractclass.MenuItem;
/**
 * A single bag of chips in a customer order.
 * Each Chip has a flavor and a fixed price.  Flavor is validated
 */
public class Chip extends MenuItem {
    private static final double CHIP_PRICE = 1.50;

    public Chip(String flavor) {
        super(flavor, CHIP_PRICE);
    }

    @Override
    public String toString(){
        return "Chips: " + getName() + " - $" +String.format("%.2f", getPrice());
    }
}
