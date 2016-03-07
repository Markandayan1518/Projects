package com.shruthi.nirmaan;

import java.io.Serializable;

/**
 * @author Shruthi
 */

public class Funds implements Serializable {
    private double fund;
    
    /**
     * Default Constructor
     */
    Funds() {
        this.fund=0.0;
    }
   
    
    /** To set Fund
     * @param amt Fund amount
     */
    public void setFund(double amt) {
        this.fund=amt;
        
    }
    
    
    /**Deducting amount from the available Fund amount
     * @param Funddeduct Fund deduct amount 
     * @return false when fund goes to negative value after the deduct
     */
    public boolean deduct(double Funddeduct) {   
    
    	this.fund -= Funddeduct;
        
        if( this.fund < 0 ) { 
        	System.out.println("Cannot perform transaction Funds empty");
            this.fund+=Funddeduct;
            return false;
        }
        
        return true;
    }
    
    /**Adding  amount to the available Fund amount
     * @param newfund new fund amount
     */
    public void add(double newfund) {
        this.fund += newfund;
    }
}
