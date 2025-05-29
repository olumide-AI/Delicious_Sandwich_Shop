package com.delicioussandwich.ui;

/**
 * Util class for rendering application menus to the console
 */
public class Screen {
    public static void homeScreen(){
        System.out.println("+----------------------------------------+");
        System.out.println("| Welcome to our Delicious Sandwich Shop |");
        System.out.println("+----------------------------------------+");
        System.out.println("| Select [1] for New Order               |");
        System.out.println("| Select [0] to Exit Application         |");
        System.out.println("+----------------------------------------+");
    }


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


}
