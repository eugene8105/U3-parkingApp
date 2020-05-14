package com.ebobalo;

import java.io.Serializable;

public class SpecialEvent implements ISpecialEvent, Serializable {

    final static double SPECIAL_EVENT_FEE = 20.00;

    final static boolean ITS_SPECIAL = true;

    @Override
    public String Specification() {
        return "Special Event.";
    }
}
