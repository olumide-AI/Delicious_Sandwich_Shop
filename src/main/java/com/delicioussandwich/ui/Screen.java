package com.delicioussandwich.ui;

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
}
