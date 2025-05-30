package com.delicioussandwich.ui;

import java.util.List;

/**
 * Util class for rendering application menus to the console
 */
public class Screen {
    //Prints console home screen information
    public static void homeScreen(){
        System.out.println(AnsiColor.ANSI_CYAN + "+----------------------------------------+" + AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_CYAN + "| Welcome to our Delicious Sandwich Shop |" + AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_CYAN + "+----------------------------------------+" + AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_GREEN+ "| Select [1] for New Order               |" + AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_RED +  "| Select [0] to Exit Application         |" + AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_CYAN + "+----------------------------------------+" + AnsiColor.ANSI_RESET);
    }

    //Prints console order screen information
    public static void orderScreen(){
        System.out.println(AnsiColor.ANSI_CYAN + "+----------------------------------------+" + AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_CYAN + "| Welcome to our order screen            |" + AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_CYAN + "+----------------------------------------+" + AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_GREEN+ "| Select [1] to Add a sandwich           |" + AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_GREEN+ "| Select [2] to Add a drink              |" + AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_GREEN+ "| Select [3] to Add a chip               |" + AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_GREEN+ "| Select [4] to checkout sandwich        |" + AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_GREEN+ "| Select [5] to remove an item           |" + AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_GREEN+ "| Select [0] to cancel order             |" + AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_CYAN + "+----------------------------------------+" + AnsiColor.ANSI_RESET);
    }

    //Prints sandwich information console
    public static void buildSandwichMenu() {
        System.out.println(AnsiColor.ANSI_CYAN + "+------------------------------------------------+"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_CYAN + "| Let's Build your Sandwich.                     |"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_CYAN + "+------------------------------------------------+"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_GREEN+ "| Select [1] to build your own                   |"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_GREEN+ "| Select [2] for Signature BLT                   |"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_GREEN+ "| Select [3] for Signature Philly Cheese Steak   |"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_GREEN+ "| Select [4] for Signature Turkey Club           |"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_GREEN+ "| Select [5] for Signature Buffalo Chicken       |"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_GREEN+ "| Select [6] for Signature Maaike Special        |"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_CYAN + "+------------------------------------------------+"+ AnsiColor.ANSI_RESET);
    }

    //prints confirm and save feature to console
    public static void printCheckoutMenu() {
        System.out.println(AnsiColor.ANSI_CYAN + "+----------------------------------------------------+"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_GREEN+ "| Select [1] to Confirm Order                        |"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_RED +  "| Select [2] to Cancel and Return to Home            |"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_CYAN + "+----------------------------------------------------+"+ AnsiColor.ANSI_RESET);
    }

    //Prints information to let user customize toppings
    public static void printToppingCustomizationMenu() {
        System.out.println(AnsiColor.ANSI_CYAN +"+-------------------------------------------------+"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_CYAN +"| Topping Customization                           |"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_CYAN +"+-------------------------------------------------+"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_GREEN+"| [1] Add Regular Topping                         |"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_GREEN+"| [2] Add Premium Topping (Meat/Cheese)           |"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_GREEN+"| [3] Add Sauce                                   |"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_GREEN+"| [4] Add Side                                    |"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_RED +"| [5] Remove Topping                              |"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_RED +"| [0] Done Customizing                            |"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_CYAN +"+-------------------------------------------------+"+ AnsiColor.ANSI_RESET);
    }
    //Prompt for bread type
    public static void promptBreadType() {
        System.out.print(AnsiColor.ANSI_PURPLE + "Choose your bread [White, Wheat, Wrap, Rye]: "+ AnsiColor.ANSI_RESET);
    }

    //Prompt for sandwich size
    public static void promptSandwichSize() {
        System.out.print(AnsiColor.ANSI_PURPLE +"Enter a Sandwich Size [4, 8, or 12 inches]: "+ AnsiColor.ANSI_RESET);
    }

    //Prompt for bread toasting
    public static void promptToasting() {
        System.out.print(AnsiColor.ANSI_PURPLE +"Do you want it toasted? [YES or NO]: "+ AnsiColor.ANSI_RESET);
    }

    //Prompt to add more toppings
    public static void promptCustomizeToppings() {
        System.out.print(AnsiColor.ANSI_PURPLE +"Would you like to customize toppings? [YES or NO]: "+ AnsiColor.ANSI_RESET);
    }

    //Prompt for the drink menu
    public static void printDrinkMenu(List<String> drinks) {
        System.out.println(AnsiColor.ANSI_CYAN +"\n--- Available Drinks ---"+ AnsiColor.ANSI_RESET);
        for (int i = 0; i < drinks.size(); i++) {
            System.out.printf(AnsiColor.ANSI_GREEN+"%d) %s%n", i + 1, drinks.get(i)+ AnsiColor.ANSI_RESET);
        }
        System.out.print(AnsiColor.ANSI_PURPLE +"Select drink by number: "+ AnsiColor.ANSI_RESET);
    }

    //Prompt for the cup size
    public static void promptCupSize() {
        System.out.print(AnsiColor.ANSI_PURPLE +"Choose cup size [Small, Medium, Large]: "+ AnsiColor.ANSI_RESET);
    }

    //Prompt for the chips menu
    public static void printChipMenu(List<String> chips) {
        System.out.println(AnsiColor.ANSI_CYAN +"\n--- Available Chips ---"+ AnsiColor.ANSI_RESET);
        for (int i = 0; i < chips.size(); i++) {
            System.out.printf(AnsiColor.ANSI_GREEN+"%d) %s%n", i + 1, chips.get(i)+ AnsiColor.ANSI_RESET);
        }
        System.out.print(AnsiColor.ANSI_PURPLE +"Select chip by number: "+ AnsiColor.ANSI_RESET);
    }

    //Prompt for all thr toppings we have availanle
    public static void printAvailableToppings(){
        System.out.println(AnsiColor.ANSI_CYAN+"\n--- Available Toppings ---"+ AnsiColor.ANSI_RESET);

        System.out.println(AnsiColor.ANSI_GREEN+"\nRegular Toppings (Included):"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_GREEN+"- lettuce, peppers, onions, tomatoes, jalapeños, cucumbers, pickles, guacamole, mushrooms"+ AnsiColor.ANSI_RESET);

        System.out.println(AnsiColor.ANSI_GREEN+"\nSauces (Included):"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_GREEN+"- mayo, mustard, ketchup, ranch, thousand islands, vinaigrette"+ AnsiColor.ANSI_RESET);

        System.out.println(AnsiColor.ANSI_GREEN+"\nSides (Included):"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_GREEN+"- au jus, sauce, fries, potatoes salad"+ AnsiColor.ANSI_RESET);

        System.out.println(AnsiColor.ANSI_GREEN+"\nPremium Meats:"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_GREEN+"- steak, ham, salami, roast beef, chicken, bacon"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_GREEN+"  • Prices: 4\" = $1.00, 8\" = $2.00, 12\" = $3.00"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_GREEN+"  • Extra: +$0.50, $1.00, $1.50"+ AnsiColor.ANSI_RESET);

        System.out.println(AnsiColor.ANSI_GREEN+"\nPremium Cheeses:"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_GREEN+"- american, provolone, cheddar, swiss"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_GREEN+"  • Prices: 4\" = $0.75, 8\" = $1.50, 12\" = $2.25"+ AnsiColor.ANSI_RESET);
        System.out.println(AnsiColor.ANSI_GREEN+"  • Extra: +$0.30, $0.60, $0.90"+ AnsiColor.ANSI_RESET);
    }
}
