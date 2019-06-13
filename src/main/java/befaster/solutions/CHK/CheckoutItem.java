/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK;

/**
 *
 * @author robert.damian
 */
public class CheckoutItem {
    protected final int quantity;
    protected final int singleItemPrice;
    
    private final SpecialOffer availableOffer;
    
    public CheckoutItem(int quantity, int singleItemPrice) {
        this(quantity, singleItemPrice, null);
    }
    
    public CheckoutItem(int quantity, int singleItemPrice, SpecialOffer availableOffer) {
        this.quantity = quantity;
        this.singleItemPrice = singleItemPrice;
        this.availableOffer = availableOffer;
    }
    
    public int getTotal() {
        if (availableOffer == null) {
            return singleItemPrice * quantity;
        }

        DiscountPack discountPack = availableOffer.computeOfferFor(quantity);
        return discountPack.getPrice() + 
                (quantity - discountPack.getItemCount()) * singleItemPrice;
    }
    
    public CheckoutItem getIncreasedCopy() {
        return new CheckoutItem(quantity + 1, singleItemPrice, availableOffer);
    }
}


