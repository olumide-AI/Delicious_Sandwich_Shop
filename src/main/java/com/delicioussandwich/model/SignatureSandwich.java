package com.delicioussandwich.model;

public abstract class SignatureSandwich extends Sandwich{

    public SignatureSandwich(String sigSandwichName, String breadType) {
        super("8", breadType, true);
        super.setName(sigSandwichName);
    }


}
