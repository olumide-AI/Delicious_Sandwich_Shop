package com.delicioussandwich.logic;

import com.delicioussandwich.model.Order;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
        //Use string builder to append receipt info line by line
        StringBuilder stringBuilderReceipt = new StringBuilder();

        //Append the header of the receipt
        stringBuilderReceipt.append(RESTAURANT_NAME).append("\n");
        stringBuilderReceipt.append(ADDRESS).append("\n");
        stringBuilderReceipt.append("Date: ").append(getCurrentDateAndTime()).append("\n");
        stringBuilderReceipt.append("\n");
        //Append recipt infomation
        stringBuilderReceipt.append(order.getSummary()).append("\n");
        stringBuilderReceipt.append("Thank you, come again.");
        return stringBuilderReceipt.toString();

    }


}
