/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK.offers;

import befaster.solutions.CHK.discounts.DiscountPack;
import befaster.solutions.CHK.discounts.PriceForItemDiscountPack;

/**
 *
 * @author robert.damian
 */
public class PriceDiscountOffer {
    
    protected int eligibleQuantity;
    protected int price;
    
    public PriceDiscountOffer (int quantity, int price) {
        this.eligibleQuantity = quantity;
        this.price = price;
    }
    
    public DiscountPack computeOfferFor(int itemCount) {
        int groups = itemCount / eligibleQuantity;
        return new PriceForItemDiscountPack(groups * eligibleQuantity, 
                price * groups);
    }
    
    public boolean appliesTo(int quantity) {
        return quantity >= eligibleQuantity;
    }
}

