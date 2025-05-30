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
        this.toppingCategory = toppingCategory.trim().toLowerCase();
    }

    @Override
    public double getPrice(String sandwichSize) {
        //Remove any extra spaces
        sandwichSize = sandwichSize.trim();

        //Validate the right size
        if (!sandwichSize.equals("4") && !sandwichSize.equals("8") && !sandwichSize.equals("12")){
            throw new IllegalArgumentException("Invalid sandwich size: " + sandwichSize +
                    " (must be '4', '8', or '12')");
        }

        //Calculate price based on sandwich size and topping category
        if (toppingCategory.equalsIgnoreCase("meat")){
            //Meat price table
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
            } else {
                if (extraTopping){
                    return 4.50;
                }
                else {
                    return 3.00;
                }
            }
            //If category is cheese
        } else if (toppingCategory.equalsIgnoreCase("cheese")) {
            //Cheese Price table
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
            } else {
                if(extraTopping){
                    return 3.15;
                }
                else {
                    return 2.25;
                }
            }
        }
        //So compiler can work, avoid java error
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
