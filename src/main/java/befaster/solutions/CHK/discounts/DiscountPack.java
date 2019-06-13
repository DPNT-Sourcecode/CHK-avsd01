/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK.discounts;

import befaster.solutions.CHK.CheckoutCart;
import befaster.solutions.CHK.CheckoutItem;

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
    private final boolean needsAtLastTarget;
    
    public DiscountPack(String targetSKU, int targetQuantity, 
            boolean needsAtLeastTarget) {
        this.targetQuantity = targetQuantity;
        this.targetSKU = targetSKU;
        this.needsAtLastTarget = needsAtLeastTarget;
    }

    public String getTargetSKU() {
        return targetSKU;
    }

    public int getTargetQuantity() {
        return targetQuantity;
    }

    public boolean isNeedsAtLastTarget() {
        return needsAtLastTarget;
    }
    
    public abstract DiscountType getDiscountType();
    protected abstract void applyToCart(CheckoutCart cart);
    
    public void applyToCartChecked(CheckoutCart cart) {
        if (needsAtLastTarget == false) {
            applyToCart(cart);
            return ;
        }
        
        CheckoutItem item = cart.getItemWithSKU(targetSKU);
        if (item.getItemQuantity() >= targetQuantity) {
            applyToCart(cart);
        }
    }
    
    public int simulateImpactOnCart(CheckoutCart cart) {
        CheckoutCart fullCopy = cart.createCopy();
        int beforeDiscount = fullCopy.getTotalNoDiscounts();
        applyToCart(fullCopy);
        
        return beforeDiscount - fullCopy.getTotalNoDiscounts();
    } 
    
    public interface DiscountPackReceiver {
        public void discountPackReceived(DiscountPack discountPack);
    }
}




