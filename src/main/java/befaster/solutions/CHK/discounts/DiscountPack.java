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
public abstract class DiscountPack {
    public enum DiscountType {
        OTHER_FREE, PRICE_REDUCTION
    }
    
    private final String targetSKU;
    private final int targetQuantity;
    
    public DiscountPack(String targetSKU, int targetQuantity) {
        this.targetQuantity = targetQuantity;
        this.targetSKU = targetSKU;
    }

    public String getTargetSKU() {
        return targetSKU;
    }

    public int getTargetQuantity() {
        return targetQuantity;
    }
    
    public abstract DiscountType getDiscountType();
    public abstract void applyToCart(CheckoutCart cart);
    
    public interface DiscountPackReceiver {
        public void discountPackReceived(DiscountPack discountPack);
    }
}
