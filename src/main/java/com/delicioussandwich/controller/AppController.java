package com.delicioussandwich.controller;

import com.delicioussandwich.logic.OrderService;
import com.delicioussandwich.ui.AnsiColor;
import com.delicioussandwich.ui.Screen;
import java.util.Scanner;

/**
 * Coordinates the main user interaction loop: displays menus,
 * reads input, and delegates to business logic (OrderService).
 */
public class AppController {
    private final Scanner scanner;

    /*
        * Created a constructor. We created a constuctor because:
        * - We had a final variable and we needed to initalize it, with a
        * constructor we guarantee any new app run gets a scanner
        * - Gives us flexibilty for encapsulation, if we need to overload, change parameter etc
        * - prevents null pointer exception
        * - It makes sure that the scanner field is set up and ready for use every run

     */
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
                    System.out.println(AnsiColor.ANSI_CYAN +"Goodbye and Thank You" + AnsiColor.ANSI_RESET);
                    isRunning = false;
                }
                default -> System.out.println(AnsiColor.ANSI_RED+"Invalid option. Please select [1] for New Order or [0] to exit."+AnsiColor.ANSI_RESET);
            }
        }
        scanner.close();
    }
}

/*
  *A boolean flag is set up to help us better contol when we break
  * the while loop is constantly calling the home screen along as it's set to true
  * if a user input 1 it gots to a new class order service and runs the new order methods,
  new order takes a scanner, since it needs input from user
  * if user input is 0, prints out a message, the flag is now false and while loop will stop running the app
  * if neither option is selcted the default is set to print out an error message and app will continue running
  since flag is still set to true
  * We used java "arrow" syntax, it's better for error handling and we don't need a break statement
  * each arrow branch is treated as a self-contained action. Once that statement (or block) runs,
  control automatically exits the switch. There’s no falling through,
 */
