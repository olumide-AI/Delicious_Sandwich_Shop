package com.delicioussandwich.app;

import com.delicioussandwich.logic.ReceiptFile;
import com.delicioussandwich.model.menuitem.Chip;
import com.delicioussandwich.model.menuitem.Drink;
import com.delicioussandwich.model.menuitem.Sandwich;
import com.delicioussandwich.model.order.Order;
import com.delicioussandwich.model.signaturesandwiches.*;
import com.delicioussandwich.model.topping.PremiumTopping;
import com.delicioussandwich.model.topping.RegularTopping;

import java.util.Scanner;

public class Application {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;
        while ((isRunning)){
            homeScreen();
            String userInput = scanner.nextLine().toLowerCase().trim();

            switch (userInput){
                case "1":
                    newOrder();
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
    private static void homeScreen(){
        System.out.println("Welcome to our delicious sandwich shop");
        System.out.println("Select '1' for new order");
        System.out.println("Select '0' to exit application ");
    }

    private static void newOrder(){
        Order order = new Order();
        boolean isOrdering = true;

        while(isOrdering){
            orderScreen();
            String userInput = scanner.nextLine().toLowerCase().trim();

            switch (userInput){
                case "1":
                    Sandwich sandwich = buildUserSandwich();
                    order.addItem(sandwich);
                    System.out.println("Sandwich has been added to order");
                    break;
                case "2":
                    Drink drink = buildUserDrink();
                    order.addItem(drink);
                    System.out.println("Your drink has been added to your order");
                    break;
                case "3":
                    Chip chip = buildUserChip();
                    order.addItem(chip);
                    System.out.println("Your chips has been added to your order");
                    break;
                case "4":
                    userCheckout(order);
                    isOrdering = false;
                    break;
                case "0":
                    System.out.println("Order canceled. ");
                    isOrdering = false;
                    break;
                default:
                    System.out.println("Invalid options, please select 0,1,2,3, 0r 4.");


            }
        }
    }

    private static void orderScreen(){
        System.out.println("Welcome to our order screen");
        System.out.println("Select '1' to Add a sandwich");
        System.out.println("Select '2' to Add a drink");
        System.out.println("Select '3' to Add a chip");
        System.out.println("Select '4' to checkout sandwich");
        System.out.println("Select '0' to cancel order");
    }

    private static Sandwich buildUserSandwich(){
        System.out.println("Let's make your sandwich according to what you like");
        System.out.println("========");
        System.out.println("Select '1' to build your own");
        System.out.println("Select '2' for a Signature BLT");
        System.out.println("Select '3' for a Signature Philly Cheese Steak");
        System.out.println("Select '4' for a Signature Turkey Club");
        System.out.println("Select '5' for a Signature Buffalo Chicken");
        System.out.println("Select '6' for a Signature Maaike Special");

        String userSandwichChoice = scanner.nextLine().trim();

        System.out.println("Choose your bread (White, Wheat, Wrap and Rye: " );
        String breadType = scanner.nextLine().toLowerCase().trim();

        Sandwich sandwich;
        switch (userSandwichChoice){
            case "2":
                sandwich = new BaconLettuceTomato(breadType);
                break;
            case "3":
                sandwich = new PhillyCheeseSteak(breadType);
                break;
            case "4":
                sandwich = new TurkeyClub(breadType);
                break;
            case "5":
                sandwich = new BuffaloChicken(breadType);
                break;
            case "6":
                sandwich = new MaaikeSpecial(breadType);
                break;
            case "1":
            default:
                String sandwichSize;
                while (true){
                    System.out.println("Enter sandwich size (4,8, or 12 inches): ");
                    sandwichSize = scanner.nextLine().trim();
                    if(sandwichSize.equalsIgnoreCase("4") || sandwichSize.equalsIgnoreCase("8") || sandwichSize.equalsIgnoreCase("12")){
                        break;
                    }
                    System.out.println("Please enter 4 , 8, or 12");
                }
                boolean isToasted = false;
                while (true){
                    System.out.println("Do you want it toasted? (yes/no): ");
                    String toastInput = scanner.nextLine().toLowerCase().trim();
                    if(toastInput.equalsIgnoreCase("yes")){
                        isToasted = true;
                        break;
                    } else if (toastInput.equalsIgnoreCase("no")) {
                        break;
                    }
                    else {
                        System.out.println("Please enter 'yes or 'no'. ");
                    }
                }
                sandwich = new Sandwich(sandwichSize, breadType, isToasted);
                break;
        }
        System.out.println("Would you like to customize toppings? (yes/no): ");
        if(scanner.nextLine().trim().equalsIgnoreCase("yes"))
        {
            customizeToppings(sandwich);
        }
        return sandwich;
    }

    private static Drink buildUserDrink(){
        System.out.println("Enter drink of choice: ");
        String userInput = scanner.nextLine().toLowerCase().trim();
        String drinkCupSize = "";

        while(true){
            System.out.println("Choose cup size (small, medium or large): ");
            drinkCupSize = scanner.nextLine().toLowerCase().trim();
            if((drinkCupSize.equalsIgnoreCase("small")) ||drinkCupSize.equalsIgnoreCase("medium") || drinkCupSize.equalsIgnoreCase("large")){
                break;
            }
            else {
                System.out.println("Please select an appropriate cup size");
            }
        }
        return new Drink(userInput, drinkCupSize);
    }

    private static Chip buildUserChip(){
        System.out.println("Enter the chip type and flavour you want. FYI we only have one size and they're all the same price");
        String userInput = scanner.nextLine().toLowerCase().trim();
        return new Chip(userInput);
    }

    private static void userCheckout(Order order){
        System.out.println("Order Summary:");
        System.out.println(order.getSummary());
        System.out.println();

        System.out.println("Select '1' to confirm order");
        System.out.println("Select '2' to cancel order and return to home page");

        String userInput = scanner.nextLine().toLowerCase().trim();
        if(userInput.equalsIgnoreCase("1")){
            ReceiptFile.saveReceiptToFile(order);
            System.out.println("Order saved. Returning to home");
        }
        else {
            System.out.println("Order has been canceled");
        }
    }
}
