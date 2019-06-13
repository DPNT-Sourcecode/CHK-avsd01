/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK.discounts;

import befaster.solutions.CHK.CheckoutCart;

/**
 *
 * @author robert.damian
 */
public class OtherItemDiscountPack extends DiscountPack {
    
    public OtherItemDiscountPack(String itemSKU, int quantity) {
        super(itemSKU, quantity);
    }
    
    public OtherItemDiscountPack(OtherItemDiscountPack pack, int offersCount) {
        this(pack.getTargetSKU(), pack.getTargetQuantity() * offersCount);
    }

    @Override
    public DiscountType getDiscountType() {
        return DiscountType.OTHER_FREE;
    }

    @Override
    public void applyToCart(CheckoutCart cart) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
