package com.ebobalo.menus;

import com.ebobalo.Controller;

import java.util.Scanner;

public class CheckIn {

    /***
     * checkInMachineMenu method contain a while to check proper input and navigate user to the selected option
     */
    public static void checkInMachineMenu() throws InterruptedException {
        Scanner keyboard;
        Controller cl = Controller.getInstance();

        int checkInMenuOption = 0;
        String factorySetup;

        keyboard = new Scanner(System.in);
        while (checkInMenuOption != 4) {
            // static class with shared layout method(s)
            SharedTemplate.topView();

            System.out.flush();

            printCheckInMenu();

            String s = keyboard.nextLine();

            try {
                int choice = Integer.parseInt(s);
                switch (choice) {
                    case 1:
                        // 1 - Check In To TheGarage
                        factorySetup = "m";
                        cl.checkInToTheGarage(factorySetup);
                        break;
                    case 2:
                        // 2 - Special Event
                        factorySetup = "s";
                        cl.specialEvent(factorySetup);
                        break;
                    case 3:
                        // 3 - Close The Garage
                        cl.closeTheGarage();
                        break;
                    case 4:
                        // 3 - Go back to the main menu
                        checkInMenuOption = 4;
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid choice");
            }
        } // end of while loop
    }// end of checkInMachineMenu method
    /***
     *  printCheckInMenu method - output on the screen check in machine menu.
     */
    private static void printCheckInMenu () {
        System.out.println(" This is a Check/In Machine");
        System.out.println();
        System.out.println("1 - Check/In");
        System.out.println("2 - Special Event");
        System.out.println("3 - Close Garage");
        System.out.println("4 - Go back to the main menu");
        System.out.println();
    } // end of printCheckInMenu method

} // end of CheckIn class
