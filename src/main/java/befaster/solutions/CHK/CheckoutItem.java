/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author robert.damian
 */
public class CheckoutItem {
    protected final int quantity;
    protected final int singleItemPrice;
    
    private final List<SpecialOffer> availableOffers;
        
    public CheckoutItem(int quantity, int singleItemPrice, SpecialOffer... availableOffers) {
        this(quantity, singleItemPrice, Arrays.asList(availableOffers));
    }
    
    public CheckoutItem(int quantity, int singleItemPrice, Collection<SpecialOffer> availableOffers) {
        this.quantity = quantity;
        this.singleItemPrice = singleItemPrice;
        this.availableOffers = new ArrayList<>(availableOffers);
    }
    
    public int getTotal() {
        return getTotal(quantity);
    }
    
    private int getTotal(int quantity) {
        SpecialOffer bestOffer = availableOffers.stream()
                .filter(o -> o.appliesTo(quantity))
                .sorted((o1, o2) -> o1.computeOfferFor(quantity).getPrice() - 
                        o2.computeOfferFor(quantity).getPrice())
                .findFirst()
                .orElse(null);
        if (bestOffer == null) {
            return quantity * singleItemPrice;
        }
        
        DiscountPack discountPack = bestOffer.computeOfferFor(quantity);
        return discountPack.getPrice() + getTotal(quantity - 
                discountPack.getItemCount());
    }
    
    public CheckoutItem getIncreasedCopy() {
        return new CheckoutItem(quantity + 1, singleItemPrice, availableOffers);
    }
}
