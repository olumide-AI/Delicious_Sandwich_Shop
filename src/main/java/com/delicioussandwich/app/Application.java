package com.delicioussandwich.app;

import com.delicioussandwich.controller.AppController;

/**
 * Entry point for the sandwich shop application.
 * Launches the application controller.
 */
public class Application {
    public static void main(String[] args) {
        new AppController().run();
    }
}
/*
  * Method calls the AppController class and runs a method (run) to run the application.
 */

