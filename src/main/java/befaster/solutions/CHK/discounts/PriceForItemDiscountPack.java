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
public class PriceForItemDiscountPack extends DiscountPack {
    
    private final int price;
    
    public PriceForItemDiscountPack(String targetSKU, int targetCount, int price) {
        super(targetSKU, targetCount, true);
        this.price = price;
    }

    public int getItemCount() {
        return getTargetQuantity();
    }

    public int getPrice() {
        return price;
    }

    @Override
    public DiscountType getDiscountType() {
        return DiscountType.PRICE_REDUCTION;
    }

    @Override
    public void applyToCart(CheckoutCart cart) {
        cart.replace(getTargetSKU(), getTargetQuantity(), 
                new CheckoutItem("DISCOUNT", 1, price));
    }
}
