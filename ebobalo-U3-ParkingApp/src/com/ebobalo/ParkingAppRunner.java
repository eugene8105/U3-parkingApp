package com.ebobalo;

import com.ebobalo.menus.MainMenu;

public class ParkingAppRunner {

    public static void main(String[] args) {
//        FeeFactory factory = FeeFactory.getInstance();
//
//        Client client = null;
//
//        Scanner userInput = new Scanner(System.in);
//
//        System.out.print("What type of payment? (s / l / m)");
//
//        if (userInput.hasNextLine()) {
//
//            String typeOfPayment = userInput.nextLine();
//
//            client = factory.makeFee(typeOfPayment);
//
//            if (client != null) {
//
//                doStuffFee(client);
//
//            } else System.out.print("Please enter s or l next time");
//
//        }
        try {
            MainMenu.machineSelection();
        } catch (InterruptedException e) {
            System.out.println("Something went wrong in machine selection menu.");
            System.out.println(e.getMessage());
        }
    }
//    public static void doStuffFee(Client client){
//
//        client.displayPayment();
//        client.displayFeeFor();
//    }
}
