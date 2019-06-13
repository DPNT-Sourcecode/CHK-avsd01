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
    
    public int getPriceForSingleItem() {
        return singleItemPrice;
    }
    
    private int getTotal(int quantity) {
        return quantity * singleItemPrice;
    }

    public String getItemSKU() {
        return itemSKU;
    }
    
    public int getItemQuantity() {
        return quantity;
    }
    
    public void computeAllOffers(DiscountPackReceiver offerReceiver) {
        computeAllOffers(offerReceiver, quantity);
    }
    
    public void computeAllOffers(DiscountPackReceiver discountPackReceiver, 
            final int leftQuantity) {
        SpecialOffer bestOffer = availableOffers.stream()
                .filter(o -> o.appliesTo(leftQuantity))
                .sorted()
                .findFirst()
                .orElse(null);
        if (bestOffer == null) {
            return ;
        }
        discountPackReceiver.discountPackReceived(bestOffer.computeOfferFor(
                itemSKU, leftQuantity));
        int newLeftQuantity = leftQuantity - 
                bestOffer.getQuantityConsumedByOffer(leftQuantity);
        computeAllOffers(discountPackReceiver, newLeftQuantity);
    }
    
    public CheckoutItem getIncreasedCopy() {
        return new CheckoutItem(itemSKU, quantity + 1, singleItemPrice, availableOffers);
    }
    
    public CheckoutItem getDecreasedCopy(int amount) {
        int newAmount = amount < quantity ? quantity - amount : 0;
        return new CheckoutItem(itemSKU, newAmount, 
                singleItemPrice, availableOffers);
    }
}
