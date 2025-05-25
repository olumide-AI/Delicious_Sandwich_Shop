package com.delicioussandwich.model.topping;

import com.delicioussandwich.model.abstractclass.Topping;

public class RegularTopping extends Topping {
    //Constructor
    public RegularTopping(String name) {
        super(name);
    }

    /**
     *
     * @param sandwichSize is the size of the sandwich and can be either (4,8,or 12) inches
     * @return will return 0 because regular toppings is free to customers
     */
    @Override
    public double getPrice(String sandwichSize) {
        return 0.0;
    }

    @Override
    public String toString(){
        return "Regular Topping: " + name;
    }
}
