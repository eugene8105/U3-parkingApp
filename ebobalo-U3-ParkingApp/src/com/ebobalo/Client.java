package com.ebobalo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Client implements Serializable {

    public static int idGenerator = 1;

    /***
     * Using Strategy pattern
     */
    ISpecialEvent feeSpecs;
    IMinMax minMax;
    ILostTicket lostTick;

    // client ID
    private  int ticketId;
    public int getTicketId() {
        return ticketId;
    }
    public void setTicketId(int newId) {
        this.ticketId = newId;
    }

    // dateTimeIn - when customer is entered the parking
    private LocalDateTime dateTimeIn;
    public LocalDateTime getDateTimeIn() {
        return dateTimeIn;
    }
    public void setDateTimeIn(LocalDateTime dateTimeIn) {
        this.dateTimeIn = dateTimeIn;
    }

    // dateTimeOut - it will setting the value with time and date when client will be out of the parking.
    private LocalDateTime dateTimeOut;
    public LocalDateTime getDateTimeOut() {
        return dateTimeOut;
    }
    public void setDateTimeOut(LocalDateTime dateTimeOut) {
        this.dateTimeOut = dateTimeOut;
    }

    private String feeSpecification;
    public String getFeeSpecification() { return feeSpecification; }
    public void setFeeSpecification(String newName) { feeSpecification = newName; }

    private boolean isSpecial;
    public boolean getIsSpecial() {
        return isSpecial;
    }
    public void setIsSpecial(boolean special) {
        isSpecial = special;
    }

    // checking if client lost ticket
    private boolean ticketLost;
    public boolean getTicketLost() {
        return ticketLost;
    }
    public void setTicketLost(boolean ticketLost) {
        this.ticketLost = ticketLost;
    }

    // fee charged
    private double charged;
    public Double getCharged() { return charged; }
    public void setCharged(Double newFee) { charged = newFee; }

    private double minFee;
    public double getMinFee() {
        return minFee;
    }
    public void setMinFee(double minFee) {
        this.minFee = minFee;
    }

    private double extraHourFee;
    public double getExtraHourFee() {
        return extraHourFee;
    }
    public void setExtraHourFee(double extraHourFee) {
        this.extraHourFee = extraHourFee;
    }

    private double maxFee;
    public double getMaxFee() {
        return maxFee;
    }
    public void setMaxFee(double maxFee) {
        this.maxFee = maxFee;
    }

    private boolean didICheckedOut;
    public boolean getDidICheckedOut() {
        return didICheckedOut;
    }
    public void setDidICheckedOut(boolean didICheckedOut) {
        this.didICheckedOut = didICheckedOut;
    }

    private int minutesParked = 0;
    public int getMinutesParked() {
        return minutesParked;
    }
    public void setMinutesParked(int minutesParked) {
        this.minutesParked = minutesParked;
    }

    public Client(){
        setTicketId(idGenerator);
        idGenerator++;
    }

    public void displayFeeFor(){
        System.out.println(getFeeSpecification());
    }

    public void displayPayment(){
        System.out.println(getCharged() + " will be charged.");
    }
}
