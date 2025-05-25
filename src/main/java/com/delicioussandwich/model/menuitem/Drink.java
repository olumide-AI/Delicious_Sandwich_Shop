package com.delicioussandwich.model.menuitem;

import com.delicioussandwich.model.abstractclass.MenuItem;

public class Drink extends MenuItem {
    private String drinkCupSize;

    /**
     *
     * @param name of the drink
     * @param drinkCupSize the actually size can be small, medium or large
     */
    public Drink(String name, String drinkCupSize) {
        super(drinkCupSize + " " + name, calcPrice(drinkCupSize));
        this.drinkCupSize = drinkCupSize;
    }
    //Getters Only
    public String getDrinkCupSize() {
        return drinkCupSize;
    }

    //Method to determine Price based on the cup size
    private static double calcPrice(String drinkCupSize){
        if(drinkCupSize.equalsIgnoreCase("small")){
            return 2.00;
        } else if (drinkCupSize.equalsIgnoreCase("medium")) {
            return 2.50;
        } else if (drinkCupSize.equalsIgnoreCase("large")) {
            return 3.00;
        }
        else {
            return 0.0;
        }
    }

    @Override
    public String toString() {
        return "Drink: " + getName() + " - $" + String.format("%.2f", getPrice());
    }
}
