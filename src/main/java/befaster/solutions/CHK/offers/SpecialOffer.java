/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK.offers;

import befaster.solutions.CHK.discounts.DiscountPack;

/**
 *
 * @author robert.damian
 */
public abstract class SpecialOffer implements Comparable<SpecialOffer>{
    protected final int eligibleQuantity;
    
    public SpecialOffer(int eligibleQuantity) {
        this.eligibleQuantity = eligibleQuantity;
    }
    
    public abstract DiscountPack computeOfferFor(int itemCount);
    
    public boolean appliesTo(int quantity) {
        return quantity >= eligibleQuantity;
    }
    
    public interface SpecialOfferReceiver {
        public void specialOfferReceived(SpecialOffer offer);
    }

    @Override
    public int compareTo(SpecialOffer o) {
        return eligibleQuantity - o.eligibleQuantity;
    }
    
    
}



