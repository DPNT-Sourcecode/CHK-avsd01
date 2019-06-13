/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK.discounts;

import befaster.solutions.CHK.CheckoutCart;

/**
 *
 * @author robert.damian
 */
public abstract class DiscountPack {
    public enum DiscountType {
        OTHER_FREE, PRICE_REDUCTION
    }
    
    public abstract DiscountType getDiscountType();
    
    public interface DiscountPackReceiver {
        public void discountPackReceived(DiscountPack discountPack);
    }
    
    
}



