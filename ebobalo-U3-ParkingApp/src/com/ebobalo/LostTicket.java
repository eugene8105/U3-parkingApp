package com.ebobalo;

import java.io.Serializable;

public class LostTicket implements ILostTicket, Serializable {

    @Override
    public String Specification() {
        return "Lost Ticket.";
    }
}
