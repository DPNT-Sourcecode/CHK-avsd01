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
public class PriceForItemDiscountPack extends DiscountPack {
    
    private final int itemCount;
    private final int price;
    
    public PriceForItemDiscountPack(int itemCount, int price) {
        this.itemCount = itemCount;
        this.price = price;
    }

    public int getItemCount() {
        return itemCount;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

