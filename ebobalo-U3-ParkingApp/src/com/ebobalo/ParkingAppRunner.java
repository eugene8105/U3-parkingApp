package com.ebobalo;

import com.ebobalo.menus.MainMenu;

public class ParkingAppRunner {

    public static void main(String[] args) {
        try {
            MainMenu.machineSelection();
        } catch (InterruptedException e) {
            System.out.println("Something went wrong in machine selection menu.");
            System.out.println(e.getMessage());
        }
    } // end of main method
} // end of ParkingAppRunner class
