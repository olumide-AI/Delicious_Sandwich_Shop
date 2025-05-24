package com.delicioussandwich.model;

/**
 * The premium toppings class will ask use if they want an extra charge
 * for more toppings based on sandwich size
 */

public class PremiumTopping extends Topping{
    private boolean extraTopping;

    //Constructor
    public PremiumTopping(String name, boolean extraTopping) {
        super(name);
        this.extraTopping = extraTopping;
    }

    //Getters and Setters


    public boolean isExtraTopping() {
        return extraTopping;
    }

    public void setExtraTopping(boolean extraTopping) {
        this.extraTopping = extraTopping;
    }

    @Override
    public double getPrice(String sandwichSize) {
        if(sandwichSize.equalsIgnoreCase("4")){
            if(extraTopping == true){
                return 1.50;
            }
            else{
                return 1.00;
            }
        } else if (sandwichSize.equalsIgnoreCase("8")) {
            if(extraTopping == true){
                return 3.00;
            }
            else{
                return 2.00;
            }
        } else if (sandwichSize.equalsIgnoreCase("12")) {
            if(extraTopping == true){
                return 4.50;
            }
            else{
                return 3.00;
            }
        }
        else{
            return 0.0;
        }
    }
    @Override
    public String toString(){
        return getName();
    }

    @Override
    public String getName(){
        if (extraTopping == true){
            return "Extra Premium" + name;
        }
        else {
            return name;
        }
    }
}
