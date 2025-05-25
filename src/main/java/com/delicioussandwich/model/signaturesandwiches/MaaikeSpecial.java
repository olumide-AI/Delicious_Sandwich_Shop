package com.delicioussandwich.model.signaturesandwiches;

import com.delicioussandwich.model.abstractclass.SignatureSandwich;

import com.delicioussandwich.model.topping.PremiumTopping;
import com.delicioussandwich.model.topping.RegularTopping;


public class MaaikeSpecial extends SignatureSandwich {
    public MaaikeSpecial(String breadType) {
        super("Veggie Delight", breadType);
        addTopping(new PremiumTopping("Tofu", "meat", false));
        addTopping(new RegularTopping("Lettuce"));
        addTopping(new RegularTopping("Tomato"));
        addTopping(new RegularTopping("Cucumber"));
        addTopping(new RegularTopping("Spinach"));
        addTopping(new RegularTopping("Avocado"));
        addTopping(new RegularTopping("Honey Mustard"));
    }
}
