/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK.offers;

import befaster.solutions.CHK.discounts.DiscountPack;
import befaster.solutions.CHK.discounts.OtherItemDiscountPack;

/**
 *
 * @author robert.damian
 */
public class DiscountOtherProductOffer extends SpecialOffer {
    public DiscountOtherProductOffer(int eligibleItemQuantity, 
            SpecialOfferEvent generatedEvent) {
        super(eligibleItemQuantity);
    }

    @Override
    public DiscountPack computeOfferFor(int itemCount) {
        return new OtherItemDiscountPack(itemCount, itemCount);
    }
    
    public static class SpecialOfferEvent {
        private final String itemSKU;
        private final int itemQuantity;
        
        public SpecialOfferEvent(String itemSKU, int itemQuantity) {
            this.itemQuantity = itemQuantity;
            this.itemSKU = itemSKU;
        } 
        
        
    }
    
    public interface OfferEventListener {
        
    }
}


