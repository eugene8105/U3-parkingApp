package com.ebobalo;

public class LostTicket extends Client {

    private static LostTicket lostTicketFirstInstance;

    final static double LOST_TICKET_FEE = 25.00;

    private LostTicket(){
        setFeeSpecification("Lost Ticket.");
        setCharged(LOST_TICKET_FEE);
        setTicketLost(true);
    } // end of LostTicket constructor

    /***
     *  Applying the Singleton Pattern.
     *  This method checking if instance of MinMax class was created and it return tha instance of it.
     *  If instance wasn't created it will create one and return it,
     *  end if instance already exist it will return existed instance.
     * @return
     */
    public static LostTicket getInstance(){
        if(lostTicketFirstInstance == null){
            lostTicketFirstInstance = new LostTicket();
        }
        return lostTicketFirstInstance;
    }

} // end of LostTicket class
