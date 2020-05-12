package com.ebobalo.factories;

import com.ebobalo.Client;
import com.ebobalo.LostTicket;
import com.ebobalo.MinMax;
import com.ebobalo.SpecialEvent;

public class FeeFactory {

    private static FeeFactory feeFactoryInstance = null;

    private FeeFactory(){
    }

    /***
     *  Applying the Singleton Pattern.
     *  This method checking if instance of MinMax class was created and it return tha instance of it.
     *  If instance wasn't created it will create one and return it,
     *  end if instance already exist it will return existed instance.
     * @return
     */
    public static FeeFactory getInstance(){
        if(feeFactoryInstance == null){
            feeFactoryInstance = new FeeFactory();
        }
        return feeFactoryInstance;
    }

    /***
     * makeFee method choosing proper fee to create buy request.
     * @param newClientFee
     * @return
     */
    public Client makeFee(String newClientFee){

        if (newClientFee.equals("l")){
            /***
             *  decided to do a Singleton for LostTicket class.
             */
            return LostTicket.getInstance();

        } else if(newClientFee.equals("s")){

            return new SpecialEvent();

        } else if(newClientFee.equals("m")){

            return new MinMax();

        } else{
            return null;
        }
    }

} // end of FeeFactory class
