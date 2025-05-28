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

        System.out.println("Choose your bread (White, Wheat, Wrap and Rye: ");
        String breadType = scanner.nextLine().toLowerCase().trim();

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
        System.out.println("Enter drink of choice: ");
        String userInput = scanner.nextLine().toLowerCase().trim();
        String drinkCupSize;

        while (true) {
            System.out.println("Choose cup size [Small, ,Medium or Large]: ");
            drinkCupSize = scanner.nextLine().toLowerCase().trim();
            if ((drinkCupSize.equalsIgnoreCase("small")) || drinkCupSize.equalsIgnoreCase("medium") || drinkCupSize.equalsIgnoreCase("large")) {
                break;
            } else {
                System.out.println("Please select an appropriate cup size");
            }
        }
        return new Drink(userInput, drinkCupSize);
    }

    public static Chip buildUserChip(Scanner scanner) {
        System.out.println("Enter the chip type and flavour you want. FYI we only have one size and they're all the same price");
        String userInput = scanner.nextLine().toLowerCase().trim();
        return new Chip(userInput);
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
                    System.out.print("Enter topping name: ");
                    String premiumName = scanner.nextLine().trim();
                    System.out.print("Meat or Cheese? ");
                    String category = scanner.nextLine().trim();
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
