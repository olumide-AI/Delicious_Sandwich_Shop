package com.delicioussandwich.ui;

import java.util.List;

/**
 * Util class for rendering application menus to the console
 */
public class Screen {
    //Prints console home screen information
    public static void homeScreen(){
        System.out.println("+----------------------------------------+");
        System.out.println("| Welcome to our Delicious Sandwich Shop |");
        System.out.println("+----------------------------------------+");
        System.out.println("| Select [1] for New Order               |");
        System.out.println("| Select [0] to Exit Application         |");
        System.out.println("+----------------------------------------+");
    }

    //Prints console order screen information
    public static void orderScreen(){
        System.out.println("+----------------------------------------+");
        System.out.println("| Welcome to our order screen            |");
        System.out.println("+----------------------------------------+");
        System.out.println("| Select [1] to Add a sandwich           |");
        System.out.println("| Select [2] to Add a drink              |");
        System.out.println("| Select [3] to Add a chip               |");
        System.out.println("| Select [4] to checkout sandwich        |");
        System.out.println("| Select [0] to cancel order             |");
        System.out.println("+----------------------------------------+");
    }

    //Prints sandwich information console
    public static void buildSandwichMenu() {
        System.out.println("+------------------------------------------------+");
        System.out.println("| Let's Build your Sandwich.                     |");
        System.out.println("+------------------------------------------------+");
        System.out.println("| Select [1] to build your own                   |");
        System.out.println("| Select [2] for Signature BLT                   |");
        System.out.println("| Select [3] for Signature Philly Cheese Steak   |");
        System.out.println("| Select [4] for Signature Turkey Club           |");
        System.out.println("| Select [5] for Signature Buffalo Chicken       |");
        System.out.println("| Select [6] for Signature Maaike Special        |");
        System.out.println("+------------------------------------------------+");
    }

    //prints confirm and save feature to console
    public static void printCheckoutMenu() {
        System.out.println("+----------------------------------------------------+");
        System.out.println("| Select [1] to Confirm Order                        |");
        System.out.println("| Select [2] to Cancel and Return to Home            |");
        System.out.println("+----------------------------------------------------+");
    }

    //Prints information to let user customize toppings
    public static void printToppingCustomizationMenu() {
        System.out.println("+-------------------------------------------------+");
        System.out.println("| Topping Customization                           |");
        System.out.println("+-------------------------------------------------+");
        System.out.println("| [1] Add Regular Topping                         |");
        System.out.println("| [2] Add Premium Topping (Meat/Cheese)           |");
        System.out.println("| [3] Add Sauce                                   |");
        System.out.println("| [4] Add Side                                    |");
        System.out.println("| [5] Remove Topping                              |");
        System.out.println("| [0] Done Customizing                            |");
        System.out.println("+-------------------------------------------------+");
    }
    //Prompt for bread type
    public static void promptBreadType() {
        System.out.print("Choose your bread [White, Wheat, Wrap, Rye]: ");
    }

    //Prompt for sandwich size
    public static void promptSandwichSize() {
        System.out.print("Enter a Sandwich Size [4, 8, or 12 inches]: ");
    }

    //Prompt for bread toasting
    public static void promptToasting() {
        System.out.print("Do you want it toasted? [YES or NO]: ");
    }

    //Prompt to add more toppings
    public static void promptCustomizeToppings() {
        System.out.print("Would you like to customize toppings? [YES or NO]: ");
    }

    //Prompt for the drink menu
    public static void printDrinkMenu(List<String> drinks) {
        System.out.println("\n--- Available Drinks ---");
        for (int i = 0; i < drinks.size(); i++) {
            System.out.printf("%d) %s%n", i + 1, drinks.get(i));
        }
        System.out.print("Select drink by number: ");
    }

    //Prompt for the cup size
    public static void promptCupSize() {
        System.out.print("Choose cup size [Small, Medium, Large]: ");
    }

    //Prompt for the chips menu
    public static void printChipMenu(List<String> chips) {
        System.out.println("\n--- Available Chips ---");
        for (int i = 0; i < chips.size(); i++) {
            System.out.printf("%d) %s%n", i + 1, chips.get(i));
        }
        System.out.print("Select chip by number: ");
    }

    //Prompt for all thr toppings we have availanle
    public static void printAvailableToppings(){
        System.out.println("\n--- Available Toppings ---");

        System.out.println("\nRegular Toppings (Included):");
        System.out.println("- lettuce, peppers, onions, tomatoes, jalapeños, cucumbers, pickles, guacamole, mushrooms");

        System.out.println("\nSauces (Included):");
        System.out.println("- mayo, mustard, ketchup, ranch, thousand islands, vinaigrette");

        System.out.println("\nSides (Included):");
        System.out.println("- au jus, sauce, fries, potatoes salad");

        System.out.println("\nPremium Meats:");
        System.out.println("- steak, ham, salami, roast beef, chicken, bacon");
        System.out.println("  • Prices: 4\" = $1.00, 8\" = $2.00, 12\" = $3.00");
        System.out.println("  • Extra: +$0.50, $1.00, $1.50");

        System.out.println("\nPremium Cheeses:");
        System.out.println("- american, provolone, cheddar, swiss");
        System.out.println("  • Prices: 4\" = $0.75, 8\" = $1.50, 12\" = $2.25");
        System.out.println("  • Extra: +$0.30, $0.60, $0.90");
    }
}
