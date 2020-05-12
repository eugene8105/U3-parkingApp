package com.ebobalo.menus;

import com.ebobalo.Controller;

import java.util.Scanner;

/***
 * Menu class will point a user to a check in or check out machine.
 */
public class Menu {
    /***
     * machineSelection method contain a while to check proper input and navigate user to the selected option
     */
    public static void machineSelection() throws InterruptedException {
        Scanner keyboard;

        int mainMenuOption = 0;
        Controller cl = Controller.getInstance();

        keyboard = new Scanner(System.in);
        while (mainMenuOption != 3) {
            // static class with shared layout method(s)
            SharedTemplate.topView();

            System.out.flush();

            printMainMenu();

            String s = keyboard.nextLine();

            try {
                int choice = Integer.parseInt(s);
                switch (choice) {
                    case 1:
                        // 1 - Check/In menu
                        CheckIn.checkInMachineMenu();
                        break;
                    case 2:
                        // 2 - Check/Out menu
                        CheckOut.checkOutMachineMenu();
                        break;
                    case 3:
                        // 5 - Exit
                        System.out.println("Goodbye");
                        cl.writeDataFile();
                        mainMenuOption = 3;
                        System.exit(0);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice");
            }
        } // end of While loop

    } // end of machineSelection method

    /***
     *  printMainMenu method - output on the screen of main menu.
     */
    private static void printMainMenu() {
        System.out.println();
        System.out.println("Which machine would you like to use?");
        System.out.println("Check In - enter 1");
        System.out.println("Check Out - enter 2");
        System.out.println("Exit - enter 3");
    }
} // end of Menu class
