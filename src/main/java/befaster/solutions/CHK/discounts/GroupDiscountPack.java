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
public class GroupDiscountPack extends DiscountPack{

    public GroupDiscountPack(String targetSKU, int targetQuantity, boolean needsAtLeastTarget) {
        super(targetSKU, targetQuantity, needsAtLeastTarget);
    }

    @Override
    public DiscountType getDiscountType() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected void applyToCart(CheckoutCart cart) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
