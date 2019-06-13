/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK;

import befaster.solutions.CHK.discounts.DiscountPack.DiscountPackReceiver;
import befaster.solutions.CHK.offers.SpecialOffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author robert.damian
 */
public class CheckoutItem {
    protected final String itemSKU;
    protected final int quantity;
    protected final int singleItemPrice;
    
    private final List<SpecialOffer> availableOffers;
        
    public CheckoutItem(String itemSKU, int quantity, int singleItemPrice, SpecialOffer... availableOffers) {
        this(itemSKU, quantity, singleItemPrice, Arrays.asList(availableOffers));
    }
    
    public CheckoutItem(String itemSKU, int quantity, int singleItemPrice, Collection<SpecialOffer> availableOffers) {
        this.quantity = quantity;
        this.singleItemPrice = singleItemPrice;
        this.availableOffers = new ArrayList<>(availableOffers);
        this.itemSKU = itemSKU;
    }
    
    public int getTotal() {
        return getTotal(quantity);
    }
    
    private int getTotal(int quantity) {
        return quantity * singleItemPrice;
    }

    public String getItemSKU() {
        return itemSKU;
    }
    
    public void computeAllOffers(DiscountPackReceiver offerReceiver) {
        computeAllOffers(offerReceiver, quantity);
    }
    
    public void computeAllOffers(DiscountPackReceiver discountPackReceiver, 
            int leftQuantity) {
        SpecialOffer bestOffer = availableOffers.stream()
                .filter(o -> o.appliesTo(quantity))
                .sorted()
                .findFirst()
                .orElse(null);
        if (bestOffer == null) {
            return ;
        }
        bestOffer.computeOfferFor(leftQuantity);
        discountPackReceiver.discountPackReceived(bestOffer.computeOfferFor(
                leftQuantity));
        leftQuantity = leftQuantity - 
                bestOffer.getQuantityConsumedByOffer(leftQuantity);
        computeAllOffers(discountPackReceiver, leftQuantity);
    }
    
    public CheckoutItem getIncreasedCopy() {
        return new CheckoutItem(quantity + 1, singleItemPrice, availableOffers);
    }
}


