package com.ebobalo;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Random;

/**
 * Utilities class with static methods
 */
public class GarageUtilities{

    static LocalDateTime inTime;
    static LocalDateTime outTime;
    static LocalDateTime timeParked;
    private static int clientId;
    private static double feeForParking = 0.0;
    private static long remainderMin = 0;
    private static double remainderFee = 0.0;
    private static int quotient;

    private static DecimalFormat df = new DecimalFormat("0.00");

    static LocalDateTime setTimeIn(){
        inTime = LocalDateTime.now();
        return inTime;
    }
    // returns a number of minutes was parked.
    static long calcParkedTime(LocalDateTime tOut, LocalDateTime tIn){ // int minParked, LocalDateTime inTime

        long minutes = ChronoUnit.MINUTES.between(tIn, tOut);
        return minutes;
    } // end of testDateTime method
    // rendNumGenerator will generate number with minimum 30 minutes and maximum timeIn number will pass into a method
    public static int rendNumGenerator (int timeIn){
        // timeIn must be higher number then timeOut
        int timeOut = 30;
        Random random = new Random();
        int randomNumber = random.nextInt(timeIn - timeOut) + timeOut;
        return randomNumber;
    } // end of rendNumGenerator

    public static double calcFeeForParking(long minParked, double minFeeUpTo3Hour, double max24HrFee, double feePerHourOrPart){
        if(minParked <= 180){
            feeForParking = minFeeUpTo3Hour;
        }if(minParked >= 180 || minParked < 1440){
            feeForParking = minFeeUpTo3Hour;
            long tempMinParked = minParked - 180;
            minParked = tempMinParked / 60;
            double tempParkingFee = minParked * feePerHourOrPart;
            feeForParking = feeForParking + tempParkingFee;
        }if(minParked >= 1440){
            feeForParking = max24HrFee;
        }
        return feeForParking;
    } // end of calcFeeForParking method

} // end of Utilities class
