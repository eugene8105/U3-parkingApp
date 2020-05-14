package com.ebobalo;

public class LostTicketSetUp extends Client {

    private static LostTicketSetUp lostTicketSetUpFirstInstance;

    /***
     * Using Strategy pattern.
     *  lostTick instance of an interface
     */
    private LostTicketSetUp(){
        // lostTick located inside of Client class.
        lostTick = new LostTicket();
        setFeeSpecification(lostTick.Specification());
        setCharged(lostTick.LOST_TICKET_FEE);
        setTicketLost(lostTick.TICKET_LOST);
    } // end of LostTicket constructor

    /***
     *  Applying the Singleton Pattern.
     *  This method checking if instance of MinMax class was created and it return tha instance of it.
     *  If instance wasn't created it will create one and return it,
     *  end if instance already exist it will return existed instance.
     * @return
     */
    public static LostTicketSetUp getInstance(){
        if(lostTicketSetUpFirstInstance == null){
            lostTicketSetUpFirstInstance = new LostTicketSetUp();
        }
        return lostTicketSetUpFirstInstance;
    }

} // end of LostTicket class
