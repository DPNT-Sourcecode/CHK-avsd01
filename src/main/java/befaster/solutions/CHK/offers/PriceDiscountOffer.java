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
public class PriceDiscountOffer extends SpecialOffer{
    
    protected int price;
    
    public PriceDiscountOffer (int quantity, int price) {
        super(quantity);
        this.price = price;
    }
    
    @Override
    public DiscountPack computeOfferFor(String itemSKU, int itemCount) {
        int groups = itemCount / eligibleQuantity;
        return new PriceForItemDiscountPack(itemSKU, groups * eligibleQuantity, 
                price * groups);
    }
}
