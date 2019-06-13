/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK.offers;

/**
 *
 * @author robert.damian
 */
public class DiscountOtherProductOffer extends SpecialOffer {
    public DiscountOtherProductOffer(int itemCount, SpecialOfferEvent generatedEvent) {
        
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
