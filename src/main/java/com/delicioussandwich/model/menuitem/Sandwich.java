package com.delicioussandwich.model.menuitem;

import com.delicioussandwich.model.abstractclass.MenuItem;
import com.delicioussandwich.model.abstractclass.Topping;

import java.util.ArrayList;
import java.util.List;

/**
 * A customizable sandwich menu item.
 * Supports three fixed sizes (4, 8, 12 inches), choice of bread,
 * optional toasting, and a list of toppings (regular or premium).
 */
public class Sandwich extends MenuItem {
    //Needed Fields
    private String sandwichSize;
    private String breadType;
    private boolean toastedBread;
    private List<Topping> toppingList;

    //Constructor
    public Sandwich(String sandwichSize, String breadType, boolean toastedBread) {
        super(buildName(sandwichSize,breadType,toastedBread), 0.0);
        this.sandwichSize = sandwichSize;
        this.breadType = breadType;
        this.toastedBread = toastedBread;
        this.toppingList = new ArrayList<>();
    }
    //Helper function for the constructor
    private static String buildName(String sandwichSize, String breadType, boolean toastedBread){
        String name = sandwichSize + "\" " + breadType + " sandwich";
        if(toastedBread){
            name += " [toasted]";
        }
        return name;
    }

    //Getters and Setters
    public String getSandwichSize() {
        return sandwichSize;
    }

    public void setSandwichSize(String sandwichSize) {
        this.sandwichSize = sandwichSize;
    }

    public String getBreadType() {
        return breadType;
    }

    public void setBreadType(String breadType) {
        this.breadType = breadType;
    }

    public boolean isToastedBread() {
        return toastedBread;
    }

    public void setToastedBread(boolean toastedBread) {
        this.toastedBread = toastedBread;
    }

    public List<Topping> getToppingList() {
        return toppingList;
    }

    public void setToppingList(List<Topping> toppingList) {
        this.toppingList = toppingList;
    }

    /**
     * Adds a topping to the sandwich class
     * @param topping add this to the topping list
     */
    public void addTopping(Topping topping){
        toppingList.add(topping);
    }

    public void removeTopping(String toppingName){
        for(int i =0; i < toppingList.size(); i++){
            Topping topping = toppingList.get(i);
            if (topping.getName().equalsIgnoreCase(toppingName)){
                toppingList.remove(i);
                break;
            }
        }
    }

    @Override
    public double getPrice(){
        double regularBreadPrice = 0.0;
        if (sandwichSize.equalsIgnoreCase("4")){
            regularBreadPrice = 5.50;
        } else if (sandwichSize.equalsIgnoreCase("8")) {
            regularBreadPrice = 7.00;
        } else if (sandwichSize.equalsIgnoreCase("12")) {
            regularBreadPrice = 8.50;
        }
        else{
            regularBreadPrice = 0.0;
        }
        //Loop through topping list and find the total topping price
        double totalToppingPrice = 0.0;
        for(Topping topping: toppingList){
            totalToppingPrice += topping.getPrice(sandwichSize);
        }
        return regularBreadPrice + totalToppingPrice;
    }

    @Override
    public String toString(){
        StringBuilder description = new StringBuilder("Sandwich: " + getName() + "\n");
        description.append("Toppings:\n");
        if(toppingList.isEmpty()){
            description.append(" (none)\n");
        }
        else{
            for (Topping topping: toppingList){
                description.append(" - ").append(topping.getName()).append("\n");
            }
        }
        double totalPrice = getPrice();
        description.append(" Sandwich Price: $").append(String.format("%.2f", totalPrice));
        return description.toString();
    }
}
