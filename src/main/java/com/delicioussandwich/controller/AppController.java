package com.delicioussandwich.controller;

import com.delicioussandwich.logic.OrderService;
import com.delicioussandwich.ui.Screen;
import java.util.Scanner;

/**
 * Coordinates the main user interaction loop: displays menus,
 * reads input, and delegates to business logic (OrderService).
 */
public class AppController {
    private final Scanner scanner;

    public AppController() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Runs the main loop: shows home screen, processes commands,
     * and closes resources on exit.
     */
    public void run() {
        boolean isRunning = true;
        while (isRunning) {
            Screen.homeScreen();
            String userInput = scanner.nextLine().trim().toLowerCase();

            switch (userInput) {
                case "1" -> OrderService.newOrder(scanner);
                case "0" -> {
                    System.out.println("Goodbye and Thank You");
                    isRunning = false;
                }
                default -> System.out.println("Invalid option. Please select [1] for New Order or [0] to exit.");
            }
        }
        scanner.close();
    }
}
