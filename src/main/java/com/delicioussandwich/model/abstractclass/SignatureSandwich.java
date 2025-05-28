package com.delicioussandwich.model.abstractclass;

import com.delicioussandwich.model.menuitem.Sandwich;

/**
 * Abstract and base class for all signature sandwich, extending Sandwich class
 */
public abstract class SignatureSandwich extends Sandwich {

    public SignatureSandwich(String sigSandwichName, String breadType) {
        super("8", breadType, true);
        super.setName(sigSandwichName);
    }
}
