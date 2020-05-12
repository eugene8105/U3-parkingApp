package com.ebobalo;

public class SpecialEvent extends Client {

    final static double SPECIAL_EVENT_FEE = 20.00;

    final static boolean ITS_SPECIAL = true;

    public SpecialEvent(){
        setFeeSpecification("Special Event.");
        setIsSpecial(ITS_SPECIAL);
        setCharged(SPECIAL_EVENT_FEE);
    } // end of SpecialEvent constructor

} // end of SpecialEvent class
