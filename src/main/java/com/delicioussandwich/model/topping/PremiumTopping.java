package com.delicioussandwich.model.topping;

import com.delicioussandwich.model.abstractclass.Topping;

/**
 * The premium toppings class will ask use if they want an extra charge
 * for more toppings based on sandwich size
 */

public class PremiumTopping extends Topping {
    private final boolean extraTopping;
    private final String toppingCategory;

    //Constructor
    public PremiumTopping(String name,  String toppingCategory, boolean extraTopping) {
        super(name);
        this.extraTopping = extraTopping;
        this.toppingCategory = toppingCategory;
    }

    @Override
    public double getPrice(String sandwichSize) {
        sandwichSize = sandwichSize.trim();
        if (toppingCategory.equalsIgnoreCase("meat")){
            if(sandwichSize.equalsIgnoreCase("4")){
                if(extraTopping){
                    return 1.50;
                }
                else {
                    return 1.00;
                }
            } else if (sandwichSize.equalsIgnoreCase("8")) {
                if(extraTopping){
                    return 3.00;
                }
                else {
                    return 2.00;
                }
            } else if (sandwichSize.equalsIgnoreCase("12")) {
                if (extraTopping){
                    return 4.50;
                }
                else {
                    return 3.00;
                }
            }
        } else if (toppingCategory.equalsIgnoreCase("cheese")) {
            if(sandwichSize.equalsIgnoreCase("4")){
                if(extraTopping){
                    return 1.05;
                }
                else {
                    return 0.75;
                }
            } else if (sandwichSize.equalsIgnoreCase("8")) {
                if(extraTopping){
                    return 2.10;
                }
                else {
                    return 1.50;
                }
            } else if (sandwichSize.equalsIgnoreCase("12")) {
                if(extraTopping){
                    return 3.15;
                }
                else {
                    return 2.25;
                }
            }
        }
        //System.out.println("Not a category");
        return 0.0;
    }
    @Override
    public String toString(){
        return getName();
    }

    @Override
    public String getName(){
        if (extraTopping){
            return "Extra Premium " + name;
        }
        else {
            return name;
        }
    }
}
