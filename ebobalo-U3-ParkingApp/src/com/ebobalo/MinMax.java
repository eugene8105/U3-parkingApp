package com.ebobalo;

public class MinMax extends Client {

    // MIN_FEE is minimum fee up to 3 hours
    final static double MIN_FEE_UP_TO_3_HOUR = 5.00;
    // FEE_PER_HOUR_OR_PART an additional charge after 3 hour.
    // for each hour or part of an hour
    final static double FEE_PER_HOUR_OR_PART = 1.00;
    // MAX_FEE maximum charged for any given 24-hour period
    final static double MAX_FEE = 15.00;

    public MinMax(){
        setMinFee(MIN_FEE_UP_TO_3_HOUR);
        setMaxFee(MAX_FEE);
        setExtraHourFee(FEE_PER_HOUR_OR_PART);
    } // end of MinMax constructor

} // end of MinMax class
