package com.ebobalo.menus;

import com.ebobalo.Controller;

import java.util.Scanner;

public class CheckOut {

    private CheckOut(){}

    /***
     * checkOutMachineMenu method contain a while to check proper input and navigate user to the selected option
     */
    public static void checkOutMachineMenu() throws InterruptedException {
        Scanner keyboard;
        Controller cl = Controller.getInstance();

        int checkInMenuOption = 0;
        // pass 480 number - is minutes in 8 hour day
        // 1440 minutes is in 24 hours
        // 7200 minutes is in 5 days
        int minutesParkRange = 1440;
        String factorySetup;

        keyboard = new Scanner(System.in);
        while (checkInMenuOption != 3) {
            // static class with shared layout method(s)
            SharedTemplate.topView();

            System.out.flush();

            printCheckOutMenu();

            String s = keyboard.nextLine();

            try {
                int choice = Integer.parseInt(s);
                switch (choice) {
                    case 1:
                        // 1 - Check/Out
                        cl.checkOutFromTheGarage(minutesParkRange);
                        break;
                    case 2:
                        // 2 - Lost Ticket
                        // l - lost ticket factory
                        factorySetup = "l";
                        cl.checkOutLostTicket(factorySetup);
                        break;
                    case 3:
                        // 3 - Go back to the main menu
                        checkInMenuOption = 3;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice");
            }
        } // end of while loop
    } // end of checkInMachineMenu method

    /***
     *  printCheckOutMenu method - output on the screen check in machine menu.
     */
    private static void printCheckOutMenu() {
        System.out.println(" This is a Check/Out Machine");
        System.out.println();
        System.out.println("1 - Check/Out");
        System.out.println("2 – Lost Ticket");
        System.out.println("3 - Go back to the main menu");
        System.out.println();
    } // end of printCheckOutMenu method

} // end of CheckOut class
