/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK.offers;

import befaster.solutions.CHK.discounts.DiscountPack;
import befaster.solutions.CHK.discounts.GroupDiscountPack;

/**
 *
 * @author robert.damian
 */
public class PriceGroupDiscountOffer extends PriceDiscountOffer {
    
    private final String groupSKU;
    
    public PriceGroupDiscountOffer(String groupSKU, int quantity, int price) {
        super(quantity, price);
        this.groupSKU = groupSKU;
    }
    
    @Override
    public DiscountPack computeOfferFor(String itemSKU, int itemCount) {
        int groups = itemCount / eligibleQuantity;
        return new GroupDiscountPack(groupSKU, groups * eligibleQuantity, 
                price * groups);
    }
    
}
