package com.ebobalo;

public class MinMaxSetUp extends Client {
    /***
     * Using Strategy pattern
     * minMax instance of an interface
     */
    public MinMaxSetUp(){
        // minMax located inside of Client class.
        minMax = new MinMax();
        setMinFee(minMax.MIN_FEE_UP_TO_3_HOUR);
        setMaxFee(minMax.MAX_FEE);
        setExtraHourFee(minMax.FEE_PER_HOUR_OR_PART);
        setFeeSpecification(minMax.Specification());
    } // end of MinMax constructor

} // end of MinMax class
