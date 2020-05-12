package com.ebobalo;

import com.ebobalo.factories.FeeFactory;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Controller{

    private static Controller controllerInstance = null;

    LocalDateTime checkInTime = null;
    LocalDateTime checkOutTime = null;
    long totalMinutesParked = 0;
    boolean lostTicket = false;
    int ticketID = 0;
    boolean didICheckOut = false;
    double feeCharged = 0.0;
    private Scanner keyboard;
    int checkInsTotal = 0;
    double collectedFromCheckOut = 0.0;
    double collectedFromLostTickets = 0.0;
    double collectedAllTotal = 0.0;
    // binary file with object data
    String fileName = "clientData.txt"; // .bin
    int enteredId = 0;

    FeeFactory factory = FeeFactory.getInstance();
    Client clientTemp = new Client();

    List<Client> clientList = new ArrayList<Client>();
    private Controller(){
        clientList = FileReader.readClientFile(fileName);
        System.out.println();
    }

    public static Controller getInstance(){

        if(controllerInstance == null){
            controllerInstance = new Controller();
        }
        return controllerInstance;
    } // end of getInstance method

    public void checkInToTheGarage(String factorySetup){
        clientIdSetup();
        try {
            // so we can display time on the screen without going through the list.
            checkInTime = GarageUtilities.setTimeIn();

            clientTemp = factory.makeFee(factorySetup);
            clientTemp.setTicketId(ticketID);
            clientTemp.setDateTimeIn(checkInTime);
            clientList.add(clientTemp);

            displayOutput();
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    } // end of checkInToTheGarage method

    public void specialEvent(String factorySetup){
        clientIdSetup();
        try{
            // so we can display time on the screen without going through the list.
            checkInTime = GarageUtilities.setTimeIn();

            clientTemp = factory.makeFee(factorySetup);
            clientTemp.setTicketId(ticketID);
            clientTemp.setDateTimeIn(checkInTime);
            clientTemp.setIsSpecial(true);
            clientList.add(clientTemp);
            displayOutput();
            TimeUnit.SECONDS.sleep(1);
        }catch(Exception ex){
            System.out.println("Problem to store Client in specialEvent method in Controller class");
            System.out.println(ex.getMessage());
        }
    } // end of specialEvent method

    /***
     * this method is checking last item in the list and incensing ticket id by one.
     * It's not a good way to do it, but in this application and for this example it's ok.
     */
    public void clientIdSetup(){
        if(clientList.size() != 0){
            var num = clientList.size();
            ticketID = clientList.get(num - 1).getTicketId();
        }
        ticketID++;
    } // end of clientIdSetup method

    /***
     * displaying the output of the ticket - id, check in time...
     */
    public void displayOutput(){
        System.out.println("Your ticket id is: " + ticketID);
        System.out.println("Your check in time is " + DateTimeFormatter.ISO_LOCAL_DATE.format(checkInTime) +
                " " + DateTimeFormatter.ISO_TIME.format(checkInTime));
    }

    public void checkOutFromTheGarage(int minParkedRange) throws InterruptedException {
        try {
            if(clientList != null){
                System.out.println("Chose your ticket id : ");
                printNotCheckedOutId();
                userIdSelection();
                for(Client cl : clientList){
                    if(cl.getTicketId() == enteredId){
                        if(cl.getDidICheckedOut() == false){
                            if(cl.getIsSpecial() == true){
                                checkInTime = cl.getDateTimeIn();
                                setUpCheckOutTimeFromGarage(minParkedRange, cl.getDateTimeIn());
                                cl.setMinutesParked((int)totalMinutesParked);
                                cl.setDateTimeOut(checkOutTime);
                                cl.setDidICheckedOut(true);
                                printCheckOutReceipt(cl);
                                System.out.println("$" + cl.getCharged());
                                System.out.println();
                                Thread.sleep(1200);
                            } else{
                                checkInTime = cl.getDateTimeIn();
                                setUpCheckOutTimeFromGarage(minParkedRange, cl.getDateTimeIn());
                                feeCharged = GarageUtilities.calcFeeForParking(pullTimeParked(),
                                        cl.getMinFee(), cl.getMaxFee(), cl.getExtraHourFee());
                                cl.setMinutesParked((int)totalMinutesParked);
                                cl.setDateTimeOut(checkOutTime);
                                cl.setDidICheckedOut(true);
                                cl.setCharged(feeCharged);
                                printCheckOutReceipt(cl);
                                System.out.println( + feeCharged);
                                System.out.println();
                                Thread.sleep(1200);
                            }
                        } // end of if statement
                        else{
                            System.out.println("This ticket has benn checked out.");
                        }
                    } // end of if statement
                }
            } // end of if statement for checking if list is empty
            else{
                System.out.println("Garage is empty.");
                Thread.sleep(1000);
            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
            System.out.println(" It' was a problem: " + e.getMessage());
        }
    } // end of checkOutFromTheGarage method

    public void checkOutLostTicket(String factorySetup) {
        System.out.println("Chose your ticket id : ");
        printNotCheckedOutId();
        userIdSelection();
        try{
            for(Client cl : clientList){
                if(cl.getTicketId() == enteredId) {
                    clientTemp = factory.makeFee(factorySetup);

                    cl.setFeeSpecification(clientTemp.getFeeSpecification());
                    cl.setCharged(clientTemp.getCharged());
                    cl.setTicketId(enteredId);
                    cl.setDidICheckedOut(true);
                    cl.setDateTimeOut(LocalDateTime.now());

                    printCheckOutReceipt(cl);

                    System.out.print(cl.getCharged());
                    System.out.println();
                    Thread.sleep(1000);
                }
            }
        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    } // end of checkOutLostTicket method
    // Receipt output on the screen.
    public void printCheckOutReceipt(Client cl) throws InterruptedException {
        System.out.flush();
        System.out.println();
        System.out.println("Receipt for a vehicle id " + cl.getTicketId());
        // DateTimeFormatter.ISO_LOCAL_DATE.format(checkOutTime) +
        //                " " + DateTimeFormatter.ISO_TIME.format(checkOutTime)
        System.out.println("Your check out time is " + DateTimeFormatter.ISO_LOCAL_DATE.format(cl.getDateTimeOut()) +
                " " + DateTimeFormatter.ISO_TIME.format(cl.getDateTimeOut()));
        int hour = 0;
        // checking if minutes parked is 0
        // if it's 0 it will skip division.
        if(cl.getMinutesParked() != 0){
            hour = (int)cl.getMinutesParked() / 60;
            cl.setMinutesParked((int) (hour % (cl.getMinutesParked() / 60)));
            System.out.println(hour + " hours parked");
        }
        if(cl.getFeeSpecification() != null){
            System.out.println(cl.getFeeSpecification());
        }
        System.out.print("Your payment amount: $");
    } // end of printCheckOutRacial method

    public void printNotCheckedOutId() {
        // looping through the list and print out the ticket id.
        try{
            for(Client cl : clientList){
                if(cl.getDidICheckedOut() == false) {
                    System.out.print(cl.getTicketId() + "  ");
                }
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    } // end of printIds method

    public void userIdSelection() {
        System.out.println();
        keyboard = new Scanner(System.in);
        String s = keyboard.nextLine();
        enteredId = Integer.parseInt(s);
    }

    public void printAllId() {
        // looping through the list and print out the ticket id.
        try{
            for(Client cl : clientList){
                System.out.print(cl.getTicketId() + "  ");
            }
        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    /***
     * closeTheGarage method is closing the garage and printing out fee collections on the screen
     * @throws InterruptedException
     */
    public void closeTheGarage() throws InterruptedException {
        System.out.println("Activity to Date");
        feeCollected();
        checkInsTotal = 0;
        lostTicketsFeeCollection();
        collectedAllTotal = collectedFromCheckOut + collectedFromLostTickets;
        System.out.println("$" + collectedAllTotal + " was collected overall");
        TimeUnit.SECONDS.sleep(1);
    }
    private void feeCollected(){
        for(Client cl : clientList){
            if(cl.getDidICheckedOut() != false && cl.getTicketLost() == false){
                collectedFromCheckOut += cl.getCharged();
                checkInsTotal++;
            }
        }
        System.out.println("$" + collectedFromCheckOut + " was collected from " + checkInsTotal + " Check Outs");
    } // end of fromCheckInFeeCollection method
    private void lostTicketsFeeCollection(){
        for(Client cl : clientList){
            if(cl.getDidICheckedOut() == true && cl.getTicketLost() == true){
                collectedFromLostTickets += cl.getCharged();
                checkInsTotal++;
            }
        }
        System.out.println("$" + collectedFromLostTickets + " was collected from " + checkInsTotal + " Lost Tickets");
    } // end of lostTicketsFeeCollection method
    public void setUpCheckOutTimeFromGarage(int minParked, LocalDateTime timeIn){
        checkOutTime = timeIn.plusMinutes(randomTimeParkedGenerator(minParked));
    }
    // maxMinGen - maximum number of minutes to generate minutes parked from.
    // pass 480 number - is minutes in 8 hour day
    public int randomTimeParkedGenerator(int maxMinGen){
        totalMinutesParked = GarageUtilities.rendNumGenerator(maxMinGen);
        return (int) totalMinutesParked;
    } // end of randomTimeParkedGenerator method
    public long pullTimeParked(){
        totalMinutesParked = GarageUtilities.calcParkedTime(checkInTime, checkOutTime);
        totalMinutesParked = Math.abs(totalMinutesParked);
        //System.out.println("Total minutes parked " + totalMinutesParked);
        return totalMinutesParked;
    } // end of pullTimeParked method
    public void writeDataFile(){
        FileWriter.writeClientFile(fileName, clientList);
    } // end of writeDataFile method

} // end of Controller class
