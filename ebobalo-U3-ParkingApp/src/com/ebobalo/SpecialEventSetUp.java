package com.ebobalo;

public class SpecialEventSetUp extends Client {

    /***
     * Using Strategy pattern
     * feeSpecs instance of an interface
     */
    public SpecialEventSetUp(){
        feeSpecs = new SpecialEvent();
        setFeeSpecification(feeSpecs.Specification());
        setIsSpecial(feeSpecs.ITS_SPECIAL);
        setCharged(feeSpecs.SPECIAL_EVENT_FEE);
    } // end of SpecialEvent constructor

} // end of SpecialEvent class
