package com.delicioussandwich.logic;


import com.delicioussandwich.model.menuitem.Chip;
import com.delicioussandwich.model.menuitem.Drink;
import com.delicioussandwich.model.menuitem.Sandwich;
import com.delicioussandwich.model.order.Customer;
import com.delicioussandwich.model.order.Order;
import com.delicioussandwich.model.signaturesandwiches.*;
import com.delicioussandwich.model.topping.PremiumTopping;
import com.delicioussandwich.model.topping.RegularTopping;
import com.delicioussandwich.repository.ReceiptFile;
import com.delicioussandwich.ui.AnsiColor;
import com.delicioussandwich.ui.Screen;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Provides ordering workflows: creating new orders, building items,
 * and handling checkout logic.
 */
public class OrderService {
    /**
     * Starts a new order session, displaying the order menu and
     * responding to user choices until checkout or cancel.
     * @param scanner shared Scanner for reading user input
     */
    public static void newOrder(Scanner scanner) {
        // --- Gather customer info before starting the order ---
        System.out.print(AnsiColor.ANSI_PURPLE +  "Enter your name: " + AnsiColor.ANSI_RESET);
        String name = scanner.nextLine().trim();
        System.out.print(AnsiColor.ANSI_PURPLE + "Enter your phone number: "  + AnsiColor.ANSI_RESET);
        String phoneNumber = scanner.nextLine().trim();

        // Create the customer
        Customer customer = new Customer(name, phoneNumber);

        //Create a new order
        Order order = new Order();
        order.setCustomer(customer);

        boolean isOrdering = true;

        while (isOrdering) {
            Screen.orderScreen();
            String userInput = scanner.nextLine().toLowerCase().trim();

            switch (userInput) {
                case "1":
                    //build and add a sandwich
                    Sandwich sandwich = buildUserSandwich(scanner);
                    order.addItem(sandwich);
                    System.out.println(AnsiColor.ANSI_GREEN +sandwich.getName() + " Sandwich has been added to order" +AnsiColor.ANSI_RESET);
                    break;
                case "2":
                    //build and add a drink
                    Drink drink = buildUserDrink(scanner);
                    order.addItem(drink);
                    System.out.println(AnsiColor.ANSI_GREEN +drink.getName() + " has been added to your order" +AnsiColor.ANSI_RESET);
                    break;
                case "3":
                    //build and add a chip
                    Chip chip = buildUserChip(scanner);
                    order.addItem(chip);
                    System.out.println(AnsiColor.ANSI_GREEN +chip.getName() + " has been added to your order"+AnsiColor.ANSI_RESET);
                    break;
                case "4":
                    //checkout the user order
                    userCheckout(order, scanner);
                    isOrdering = false;
                    break;
                case "5":
                    // Remove an item by name
                    System.out.print(AnsiColor.ANSI_PURPLE+"Enter the name of the item to remove: " +AnsiColor.ANSI_RESET);
                    String toRemove = scanner.nextLine().trim();

                    // attempt removal and give feedback
                    boolean removed = order.removeItemByName(toRemove);
                    if (removed) {
                        System.out.println(AnsiColor.ANSI_GREEN +"'" + toRemove + "' was removed from your order." + AnsiColor.ANSI_RESET);
                    } else {
                        System.out.println(AnsiColor.ANSI_YELLOW +"No item named '" + toRemove + "' found in your order." +AnsiColor.ANSI_RESET);
                    }
                    break;
                case "0":
                    //cancel order
                    System.out.println(AnsiColor.ANSI_RED +"Order canceled. " + AnsiColor.ANSI_RESET);
                    isOrdering = false;
                    break;
                default:
                    System.out.println(AnsiColor.ANSI_YELLOW +"Invalid options, please select 0,1,2,3, or 4." + AnsiColor.ANSI_RESET);


            }
        }
    }

    public static Sandwich buildUserSandwich(Scanner scanner) {
        //Build either a signature or a custom sandwich
        Screen.buildSandwichMenu();
        String userSandwichChoice = scanner.nextLine().trim();

        //Bread selections available
        List<String> availableBreads = List.of("white","wheat","wrap","rye");
        String breadType;
        do{
            Screen.promptBreadType();
            breadType = scanner.nextLine().toLowerCase().trim();
        }
        while (!availableBreads.contains(breadType));

        //Initialize a sandwich
        Sandwich sandwich;

        //the signature sandwiches
        switch (userSandwichChoice) {
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
                //Custom sandwich selection
                String sandwichSize;
                do {
                    Screen.promptSandwichSize();
                    sandwichSize = scanner.nextLine().trim();
                } while (!List.of("4","8","12").contains(sandwichSize));

                //Bread toasting option
                boolean isToasted = false;
                String toastInput;
                do {
                    Screen.promptToasting();
                    toastInput = scanner.nextLine().toLowerCase().trim();
                } while (!toastInput.equals("yes") && !toastInput.equals("no"));

                if (toastInput.equals("yes")) isToasted = true;
                sandwich = new Sandwich(sandwichSize, breadType, isToasted);

                //Optional topping customization
                // do a do-while for error handling here
                Screen.promptCustomizeToppings();
                if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
                    customizeToppings(sandwich, scanner);
                }
                return sandwich;
        }
        System.out.println(AnsiColor.ANSI_PURPLE +"Would you like to customize toppings? [YES or NO]: " +AnsiColor.ANSI_RESET);
        if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
            customizeToppings(sandwich, scanner);
        }
        return sandwich;
    }

    public static Drink buildUserDrink(Scanner scanner) {
        //List of drinks available to order
        List<String> drinks = List.of("Cola", "Lemonade", "Iced Tea", "Coffee", "Water");
        String drinkChoice;


        while (true) {
            //prints all items in the list and starts from 1 instead of 0
           Screen.printDrinkMenu(drinks);
           String userInput = scanner.nextLine().trim();
            //Validation
            try {
                int drinkId = Integer.parseInt(userInput);
                if (drinkId >= 1 && drinkId <= drinks.size()) {
                    drinkChoice = drinks.get(drinkId - 1);
                    break;
                }
            } catch (NumberFormatException _) { }
            System.out.println(AnsiColor.ANSI_RED +"Invalid selection. Please enter a number between 1 and " + drinks.size() +AnsiColor.ANSI_RESET);
        }
        //Validate cup against rules
        String drinkCupSize;
       do {
           Screen.promptCupSize();
           drinkCupSize = scanner.nextLine().toLowerCase().trim();
       }while(!List.of("small", "medium", "large").contains(drinkCupSize));

        return new Drink(drinkChoice, drinkCupSize);
    }
    public static Chip buildUserChip(Scanner scanner) {
        //List of all chips
        List<String> chips = List.of("LAYS", "Pringles", "Sunflower Chips", "Doritos", "Cheetos");
        String userChipChoice;

        while (true) {
            Screen.printChipMenu(chips);
            String userInput = scanner.nextLine().toLowerCase().trim();

            try {
                int chipId = Integer.parseInt(userInput);
                if (chipId >= 1 && chipId <= chips.size()) {
                    userChipChoice = chips.get(chipId - 1);
                    break;
                }
            } catch (NumberFormatException _) { }
            System.out.println(AnsiColor.ANSI_RED +"Invalid selection. Please enter a number between 1 and " + chips.size() + AnsiColor.ANSI_RESET);
        }

        return new Chip(userChipChoice);
    }

    public static void userCheckout(Order order, Scanner scanner) {
        //Add a feature asking the user of they wanted to add more order maybe in checkout menu or before

        //Prints the order summary and gives price
        System.out.println(order.getSummary());
        Screen.printCheckoutMenu();

        String userInput = scanner.nextLine().toLowerCase().trim();
        //Save file, if user confirms order
        if (userInput.equalsIgnoreCase("1")) {
            ReceiptFile.saveReceiptToFile( order);
            System.out.println(AnsiColor.ANSI_GREEN +"Order saved. Returning to home" +AnsiColor.ANSI_RESET);
        } else {
            System.out.println(AnsiColor.ANSI_RED +"Order has been canceled" +AnsiColor.ANSI_RESET);
        }
    }

    public static String getPremiumToppingCategory(String topping) {
        if (List.of("steak", "ham", "salami", "roast beef", "chicken", "bacon").contains(topping)) {
            return "Meat";
        } else if (List.of("american", "provolone", "cheddar", "swiss").contains(topping)) {
            return "Cheese";
        }
        return null;
    }


    public static void customizeToppings(Sandwich sandwich, Scanner scanner) {
        //Shows all categories and pricing for the toppings

        Screen.printAvailableToppings();

        while (true) {
            Screen.printToppingCustomizationMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    //Add a regular topping, price is 0.0
                    System.out.print(AnsiColor.ANSI_PURPLE +"Enter topping name: " +AnsiColor.ANSI_RESET);
                    String toppingName = scanner.nextLine().trim();
                    sandwich.addTopping(new RegularTopping(toppingName));
                    break;

                case "2":
                    //Add a premium topping price is unique for meat and cheese
                    System.out.print(AnsiColor.ANSI_PURPLE +"Enter premium topping name (e.g., steak, cheddar): " + AnsiColor.ANSI_RESET);
                    String premiumName = scanner.nextLine().toLowerCase().trim();

                    // Figures out if meat or cheese is the name
                    String category = getPremiumToppingCategory(premiumName);
                    if (category == null) {
                        System.out.println(AnsiColor.ANSI_RED +"Sorry, we don't offer that premium topping." + AnsiColor.ANSI_RESET);
                        break;
                    }

                    //Ask if they want more toppings
                    System.out.print(AnsiColor.ANSI_PURPLE +"Add extra? [YES or NO]: " + AnsiColor.ANSI_RESET);
                    boolean extra = scanner.nextLine().trim().equalsIgnoreCase("yes");
                    sandwich.addTopping(new PremiumTopping(premiumName, category, extra));
                    break;

                case "3":
                    //Add any sauce
                    System.out.print(AnsiColor.ANSI_PURPLE +  "Enter sauce name (e.g., mustard, ranch): " + AnsiColor.ANSI_RESET);
                    String sauce = scanner.nextLine().trim();
                    sandwich.addTopping(new RegularTopping(sauce));
                    break;

                case "4":
                    //Add any sides
                    System.out.print(AnsiColor.ANSI_PURPLE +"Enter side name (e.g., au jus, sauce, fries): " + AnsiColor.ANSI_RESET);
                    String side = scanner.nextLine().trim();
                    sandwich.addTopping(new RegularTopping(side));
                    break;

                case "5":
                    //Remove any topping by name
                    System.out.print(AnsiColor.ANSI_PURPLE +"Enter topping name to remove: " + AnsiColor.ANSI_RESET);
                    String toRemove = scanner.nextLine().trim();
                    sandwich.removeTopping(toRemove);
                    break;

                case "0":
                    //Done customizing
                    return;

                default:
                    System.out.println(AnsiColor.ANSI_RED+" Invalid input. Please choose again."+ AnsiColor.ANSI_RESET);
            }
        }
    }
}
