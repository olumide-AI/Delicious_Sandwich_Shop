package com.delicioussandwich.model.signaturesandwiches;

import com.delicioussandwich.model.abstractclass.SignatureSandwich;
import com.delicioussandwich.model.topping.PremiumTopping;
import com.delicioussandwich.model.topping.RegularTopping;

public class BuffaloChicken extends SignatureSandwich {
    public BuffaloChicken(String breadType) {
        super("Buffalo Chicken", breadType);
        addTopping(new PremiumTopping("Chicken", "meat", false));
        addTopping(new PremiumTopping("Blue Cheese", "cheese", false));
        addTopping(new RegularTopping("Lettuce"));
        addTopping(new RegularTopping("Buffalo Sauce"));
        addTopping(new RegularTopping("Ranch"));
    }
}
