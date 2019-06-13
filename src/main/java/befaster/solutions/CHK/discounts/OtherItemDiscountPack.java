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
    private final String itemSKU;
    private final int quantity;
    
    public OtherItemDiscountPack(String itemSKU, int quantity) {
        this.itemSKU = itemSKU;
        this.quantity = quantity;
    }
    
    public OtherItemDiscountPack(OtherItemDiscountPack pack, int offersCount) {
        this(pack.itemSKU, pack.quantity * offersCount);
    }

    public String getItemSKU() {
        return itemSKU;
    }

    public int getQuantity() {
        return quantity;
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

