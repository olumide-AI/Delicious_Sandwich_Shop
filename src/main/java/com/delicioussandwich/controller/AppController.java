package com.delicioussandwich.controller;

import com.delicioussandwich.logic.OrderService;
import com.delicioussandwich.ui.Screen;

import java.util.Scanner;

public class AppController {
    private final Scanner scanner = new Scanner(System.in);

    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            Screen.homeScreen();
            String userInput = scanner.nextLine().trim().toLowerCase();

            switch (userInput) {
                case "1" -> OrderService.newOrder();
                case "0" -> {
                    System.out.println("Goodbye and thank you");
                    isRunning = false;
                }
                default -> System.out.println("Invalid option. Please select [1] or [0].");
            }
        }
    }
}
