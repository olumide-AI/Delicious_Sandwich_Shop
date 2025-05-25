package com.delicioussandwich.model.signaturesandwiches;

import com.delicioussandwich.model.abstractclass.SignatureSandwich;
import com.delicioussandwich.model.topping.PremiumTopping;
import com.delicioussandwich.model.topping.RegularTopping;

public class BaconLettuceTomato extends SignatureSandwich {
    public BaconLettuceTomato (String breadType){
        super("BLT", breadType);
        addTopping(new PremiumTopping("Bacon", "meat", false));
        addTopping(new PremiumTopping("Cheddar", "chese", false));
        addTopping(new RegularTopping("Lettuce"));
        addTopping(new RegularTopping("Tomato"));
        addTopping(new RegularTopping("Ranch"));

    }
}
