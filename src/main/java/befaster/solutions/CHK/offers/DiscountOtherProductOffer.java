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
    
    private OtherItemDiscountPack suppliedDiscount;
    
    public DiscountOtherProductOffer(int eligibleItemQuantity, 
            OtherItemDiscountPack suppliedDiscount) {
        super(eligibleItemQuantity);
        this.suppliedDiscount = suppliedDiscount;
    }

    @Override
    public DiscountPack computeOfferFor(int itemCount) {
        return new OtherItemDiscountPack(suppliedDiscount);
    }
}



