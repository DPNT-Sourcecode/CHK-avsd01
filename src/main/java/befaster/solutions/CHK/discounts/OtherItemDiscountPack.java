/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK.discounts;

/**
 *
 * @author robert.damian
 */
public class OtherItemDiscountPack {
    private final String itemSKU;
    private final int quantity;
    
    public OtherItemDiscountPack(String itemSKU, int quantity) {
        this.itemSKU = itemSKU;
        this.quantity = quantity;
    }
    
    public OtherItemDiscountPack(OtherItemDiscountPack pack) {
        this(pack.itemSKU, pack.quantity);
    }

    public String getItemSKU() {
        return itemSKU;
    }

    public int getQuantity() {
        return quantity;
    }
}
