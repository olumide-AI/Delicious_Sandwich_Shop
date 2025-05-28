package com.delicioussandwich.app;

import com.delicioussandwich.logic.OrderService;
import com.delicioussandwich.logic.ReceiptFile;
import com.delicioussandwich.model.menuitem.Chip;
import com.delicioussandwich.model.menuitem.Drink;
import com.delicioussandwich.model.menuitem.Sandwich;
import com.delicioussandwich.model.order.Order;
import com.delicioussandwich.model.signaturesandwiches.*;
import com.delicioussandwich.model.topping.PremiumTopping;
import com.delicioussandwich.model.topping.RegularTopping;
import com.delicioussandwich.ui.Screen;

import java.util.Scanner;

public class Application {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;
        while ((isRunning)){
            Screen.homeScreen();
            String userInput = scanner.nextLine().toLowerCase().trim();

            switch (userInput){
                case "1":
                    OrderService.newOrder();
                    break;
                case "0":
                    System.out.println("Goodbye and thank you ");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid option. Please Select (1 or 0): ");
            }
        }
    }








}
