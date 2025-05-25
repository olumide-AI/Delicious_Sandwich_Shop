package com.delicioussandwich.model.abstractclass;

/**
 * Base class for the toppings
 */
public abstract class Topping {
    protected String name;

    //Constructor
    public Topping(String name) {
        this.name = name;
    }
    //Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @param sandwichSize is the size of the sandwich and can be either (4,8,or 12) inches
     * @return a certain price based on sandwich size
     */
    public abstract double getPrice(String sandwichSize);

    @Override
    public String toString() {
        return getName();
    }
}
