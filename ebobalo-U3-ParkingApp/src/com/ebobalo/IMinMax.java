package com.ebobalo;

public interface IMinMax {
    // MIN_FEE is minimum fee up to 3 hours
    double MIN_FEE_UP_TO_3_HOUR = 5.00;
    // FEE_PER_HOUR_OR_PART an additional charge after 3 hour.
    // for each hour or part of an hour
    double FEE_PER_HOUR_OR_PART = 1.00;
    // MAX_FEE maximum charged for any given 24-hour period
    double MAX_FEE = 15.00;

    String Specification();
}
