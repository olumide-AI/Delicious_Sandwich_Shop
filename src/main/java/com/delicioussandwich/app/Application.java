package com.delicioussandwich.app;

import com.delicioussandwich.model.Order;
import com.delicioussandwich.model.Sandwich;

import java.util.Scanner;

public class Application {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;
        while ((isRunning)){
            homeScreen();
            String userInput = scanner.nextLine().toLowerCase().trim();

            switch (userInput){
                case '1':
                    newOrder();
                    break;
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
                    Sandwich sandwich =
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
}
