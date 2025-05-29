package com.delicioussandwich.logic;

import com.delicioussandwich.model.menuitem.Chip;
import com.delicioussandwich.model.menuitem.Drink;
import com.delicioussandwich.model.menuitem.Sandwich;
import com.delicioussandwich.model.order.Order;
import com.delicioussandwich.model.signaturesandwiches.*;
import com.delicioussandwich.model.topping.PremiumTopping;
import com.delicioussandwich.model.topping.RegularTopping;
import com.delicioussandwich.repository.ReceiptFile;
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
        Order order = new Order();
        boolean isOrdering = true;

        while (isOrdering) {
            Screen.orderScreen();
            String userInput = scanner.nextLine().toLowerCase().trim();

            switch (userInput) {
                case "1":
                    Sandwich sandwich = buildUserSandwich(scanner);
                    order.addItem(sandwich);
                    System.out.println(sandwich.getName() + " Sandwich has been added to order");
                    break;
                case "2":
                    Drink drink = buildUserDrink(scanner);
                    order.addItem(drink);
                    System.out.println(drink.getName() + " has been added to your order");
                    break;
                case "3":
                    Chip chip = buildUserChip(scanner);
                    order.addItem(chip);
                    System.out.println(chip.getName() + " has been added to your order");
                    break;
                case "4":
                    userCheckout(order, scanner);
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

    public static Sandwich buildUserSandwich(Scanner scanner) {
        System.out.println("+------------------------------------------------+");
        System.out.println("| Let's Build your Sandwich.                     |");
        System.out.println("+------------------------------------------------+");
        System.out.println("| Select [1] to build your own                   |");
        System.out.println("| Select [2] for a Signature BLT                 |");
        System.out.println("| Select [3] for a Signature Philly Cheese Steak |");
        System.out.println("| Select [4] for a Signature Turkey Club         |");
        System.out.println("| Select [5] for a Signature Buffalo Chicken     |");
        System.out.println("| Select [6] for a Signature Maaike Special      |");
        System.out.println("+------------------------------------------------+");

        String userSandwichChoice = scanner.nextLine().trim();

        List<String> validBreads = List.of("white","wheat","wrap","rye");
        String breadType;
        while (true) {
            System.out.print("Choose your bread [White, Wheat, Wrap, Rye]: ");
            breadType = scanner.nextLine().toLowerCase().trim();
            if (validBreads.contains(breadType)) break;
            System.out.println("Please choose one of: " + validBreads);
        }

        Sandwich sandwich;
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
                String sandwichSize;
                while (true) {
                    System.out.println("Enter a Sandwich Size [4, 8, or 12 'inches']: ");
                    sandwichSize = scanner.nextLine().trim();
                    if (sandwichSize.equalsIgnoreCase("4") || sandwichSize.equalsIgnoreCase("8") || sandwichSize.equalsIgnoreCase("12")) {
                        break;
                    }
                    System.out.println("Please enter [4, 8, or 12 'inches']");
                }
                boolean isToasted = false;
                while (true) {
                    System.out.println("Do you want it toasted? [YES or NO]: ");
                    String toastInput = scanner.nextLine().toLowerCase().trim();
                    if (toastInput.equalsIgnoreCase("yes")) {
                        isToasted = true;
                        break;
                    } else if (toastInput.equalsIgnoreCase("no")) {
                        break;
                    } else {
                        System.out.println("Please enter [YES or NO]. ");
                    }
                }
                sandwich = new Sandwich(sandwichSize, breadType, isToasted);
                break;
        }
        System.out.println("Would you like to customize toppings? [YES or NO]: ");
        if (scanner.nextLine().trim().equalsIgnoreCase("yes")) {
            customizeToppings(sandwich, scanner);
        }
        return sandwich;
    }

    public static Drink buildUserDrink(Scanner scanner) {
        List<String> drinks = List.of("Cola", "Lemonade", "Iced Tea", "Coffee", "Water");
        String drinkChoice;

        // 1) pick a drink from the list
        while (true) {
            System.out.println("\n--- Available Drinks ---");
            for (int i = 0; i < drinks.size(); i++) {
                System.out.printf("%d) %s%n", i + 1, drinks.get(i));
            }
            System.out.print("Select drink by number: ");
            String input = scanner.nextLine().trim();

            try {
                int idx = Integer.parseInt(input);
                if (idx >= 1 && idx <= drinks.size()) {
                    drinkChoice = drinks.get(idx - 1);
                    break;
                }
            } catch (NumberFormatException _) { }
            System.out.println("Invalid selection. Please enter a number between 1 and " + drinks.size());
        }

        // 2) pick a cup size
        String drinkCupSize;
        while (true) {
            System.out.print("Choose cup size [Small, Medium, Large]: ");
            drinkCupSize = scanner.nextLine().toLowerCase().trim();
            if (List.of("small", "medium", "large").contains(drinkCupSize)) {
                break;
            }
            System.out.println("Please select Small, Medium, or Large.");
        }

        return new Drink(drinkChoice, drinkCupSize);
    }
    public static Chip buildUserChip(Scanner scanner) {
        List<String> chips = List.of("bbq", "salted", "cheddar", "sour cream", "jalapeño");
        String chipChoice;

        while (true) {
            System.out.println("\n--- Available Chips ---");
            for (int i = 0; i < chips.size(); i++) {
                System.out.printf("%d) %s%n", i + 1, chips.get(i));
            }
            System.out.print("Select chip by number: ");
            String input = scanner.nextLine().trim();

            try {
                int idx = Integer.parseInt(input);
                if (idx >= 1 && idx <= chips.size()) {
                    chipChoice = chips.get(idx - 1);
                    break;
                }
            } catch (NumberFormatException _) { }
            System.out.println("Invalid selection. Please enter a number between 1 and " + chips.size());
        }

        return new Chip(chipChoice);
    }

    public static void userCheckout(Order order, Scanner scanner) {
        System.out.println(order.getSummary());
        System.out.println();
        System.out.println("+----------------------------------------------------+");
        System.out.println("Please Select an Option Below                        |");
        System.out.println("+----------------------------------------------------+");
        System.out.println("| Select [1] to Confirm Order                        |");
        System.out.println("| Select [2] to cancel order and return to home page |");
        System.out.println("+----------------------------------------------------+");

        String userInput = scanner.nextLine().toLowerCase().trim();
        if (userInput.equalsIgnoreCase("1")) {
            ReceiptFile.saveReceiptToFile( order);
            System.out.println("Order saved. Returning to home");
        } else {
            System.out.println("Order has been canceled");
        }
    }

    public static void customizeToppings(Sandwich sandwich, Scanner scanner) {
        System.out.println("\n--- Available Toppings ---");

        System.out.println("\nRegular Toppings (Included):");
        System.out.println("- lettuce, peppers, onions, tomatoes, jalapeños, cucumbers, pickles, guacamole, mushrooms");

        System.out.println("\nSauces (Included):");
        System.out.println("- mayo, mustard, ketchup, ranch, thousand islands, vinaigrette");

        System.out.println("\nSides (Included):");
        System.out.println("- au jus, sauce");

        System.out.println("\nPremium Meats:");
        System.out.println("- steak, ham, salami, roast beef, chicken, bacon");
        System.out.println("  • Prices: 4\" = $1.00, 8\" = $2.00, 12\" = $3.00");
        System.out.println("  • Extra: +$0.50, $1.00, $1.50");

        System.out.println("\nPremium Cheeses:");
        System.out.println("- american, provolone, cheddar, swiss");
        System.out.println("  • Prices: 4\" = $0.75, 8\" = $1.50, 12\" = $2.25");
        System.out.println("  • Extra: +$0.30, $0.60, $0.90");

        while (true) {
            System.out.println("+-------------------------------------------------+");
            System.out.println("| Topping Customization                           |");
            System.out.println("+-------------------------------------------------+");
            System.out.println("| Select [1] to Add Regular Topping               |");
            System.out.println("| Select [2] to Add Premium Topping (Meat/Cheese) |");
            System.out.println("| Select [3] to Add Sauce                         |");
            System.out.println("| Select [4] to Add Side                          |");
            System.out.println("| Select [5] to Remove Topping                    |");
            System.out.println("| Select [0] when Done Customizing                |");
            System.out.println("+-------------------------------------------------+");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter topping name: ");
                    String toppingName = scanner.nextLine().trim();
                    sandwich.addTopping(new RegularTopping(toppingName));
                    break;

                case "2":
                    System.out.print("Enter premium topping name (e.g., steak, cheddar): ");
                    String premiumName = scanner.nextLine().toLowerCase().trim();

                    // detect category
                    String category;
                    if (Arrays.asList("steak","ham","salami","roast beef","chicken","bacon")
                            .contains(premiumName)) {
                        category = "Meat";
                    } else if (Arrays.asList("american","provolone","cheddar","swiss")
                            .contains(premiumName)) {
                        category = "Cheese";
                    } else {
                        System.out.println("Sorry, we don't offer that premium topping.");
                        break;
                    }

                    System.out.print("Add extra? [YES or NO]: ");
                    boolean extra = scanner.nextLine().trim().equalsIgnoreCase("yes");
                    sandwich.addTopping(new PremiumTopping(premiumName, category, extra));
                    break;

                case "3":
                    System.out.print("Enter sauce name (e.g., mustard, ranch): ");
                    String sauce = scanner.nextLine().trim();
                    sandwich.addTopping(new RegularTopping(sauce));
                    break;

                case "4":
                    System.out.print("Enter side name (e.g., au jus, sauce): ");
                    String side = scanner.nextLine().trim();
                    sandwich.addTopping(new RegularTopping(side));
                    break;

                case "5":
                    System.out.print("Enter topping name to remove: ");
                    String toRemove = scanner.nextLine().trim();
                    sandwich.removeTopping(toRemove);
                    break;

                case "0":
                    return;

                default:
                    System.out.println(" Invalid input. Please choose again.");
            }
        }
    }
}
