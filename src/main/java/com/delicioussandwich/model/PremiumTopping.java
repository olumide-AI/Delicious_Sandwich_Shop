package com.delicioussandwich.model;

/**
 * The premium toppings class will ask use if they want an extra charge
 * for more toppings based on sandwich size
 */

public class PremiumTopping extends Topping{
    private boolean extraTopping;
    private String toppingCategory;

    //Constructor
    public PremiumTopping(String name,  String toppingCategory, boolean extraTopping) {
        super(name);
        this.extraTopping = extraTopping;
        this.toppingCategory = toppingCategory;
    }

    //Getters and Setters


    public String getToppingCategory() {
        return toppingCategory;
    }

    public void setToppingCategory(String toppingCategory) {
        this.toppingCategory = toppingCategory;
    }

    public boolean isExtraTopping() {
        return extraTopping;
    }

    public void setExtraTopping(boolean extraTopping) {
        this.extraTopping = extraTopping;
    }

    @Override
    public double getPrice(String sandwichSize) {
        sandwichSize = sandwichSize.trim();
        if (toppingCategory.equalsIgnoreCase("meat")){
            if(sandwichSize.equalsIgnoreCase("4")){
                if(extraTopping == true){
                    return 1.50;
                }
                else {
                    return 1.00;
                }
            } else if (sandwichSize.equalsIgnoreCase("8")) {
                if(extraTopping == true){
                    return 3.00;
                }
                else {
                    return 2.00;
                }
            } else if (sandwichSize.equalsIgnoreCase("12")) {
                if (extraTopping == true){
                    return 4.50;
                }
                else {
                    return 3.00;
                }
            }
        } else if (toppingCategory.equalsIgnoreCase("cheese")) {
            if(sandwichSize.equalsIgnoreCase("4")){
                if(extraTopping == true){
                    return 1.05;
                }
                else {
                    return 0.75;
                }
            } else if (sandwichSize.equalsIgnoreCase("8")) {
                if(extraTopping == true){
                    return 2.10;
                }
                else {
                    return 1.50;
                }
            } else if (sandwichSize.equalsIgnoreCase("12")) {
                if(extraTopping == true){
                    return 3.15;
                }
                else {
                    return 2.25;
                }
            }
        }
        System.out.println("Not a category");
        return 0.0;
    }
    @Override
    public String toString(){
        return getName();
    }

    @Override
    public String getName(){
        if (extraTopping == true){
            return "Extra Premium " + name;
        }
        else {
            return name;
        }
    }
}
