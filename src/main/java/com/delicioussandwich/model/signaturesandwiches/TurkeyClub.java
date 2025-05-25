package com.delicioussandwich.model.signaturesandwiches;

import com.delicioussandwich.model.abstractclass.SignatureSandwich;
import com.delicioussandwich.model.topping.PremiumTopping;
import com.delicioussandwich.model.topping.RegularTopping;

public class TurkeyClub extends SignatureSandwich {
    public TurkeyClub( String breadType) {
        super("Turkey Club", breadType);
        addTopping(new PremiumTopping("Turkey", "meat", false));
        addTopping(new PremiumTopping("Swiss Cheese", "cheese", false));
        addTopping(new RegularTopping("Lettuce"));
        addTopping(new RegularTopping("Tomato"));
        addTopping(new RegularTopping("Bacon Bits"));
        addTopping(new RegularTopping("Mayo"));
    }
}
