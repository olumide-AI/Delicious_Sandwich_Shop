package com.delicioussandwich.logic;

import com.delicioussandwich.model.order.Order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Responsible for formatting user order into a printable text receipt
 */
public class Receipt {
    private static final String RESTAURANT_NAME = "DELI-cious Sandwich Shop";
    private static final String ADDRESS = "303 2nd st, San Francisco, CA";

    //Returns date, time for us to use when we generate our receipt
    private static String getCurrentDateAndTime(){
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm a");
        return currentTime.format(formatter);
    }
    public static String generateReceipt(Order order){
        return RESTAURANT_NAME + "\n" +
                ADDRESS + "\n" +
                "Date: " + getCurrentDateAndTime() + "\n" +
                "\n" +
                //Append receipt information
                order.getSummary() + "\n" +
                "Thank you, come again.";

    }


}
