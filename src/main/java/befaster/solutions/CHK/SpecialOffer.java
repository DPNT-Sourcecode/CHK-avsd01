/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK;

/**
 *
 * @author robert.damian
 */
public class SpecialOffer {
    
    protected int eligibleQuantity;
    protected int price;
    
    public SpecialOffer (int quantity, int price) {
        this.eligibleQuantity = quantity;
        this.price = price;
    }
    
    public DiscountPack computeOfferFor(int itemCount) {
        int groups = itemCount / eligibleQuantity;
        return new DiscountPack(groups * eligibleQuantity, price * groups);
    }
    
    public boolean appliesTo(int quantity) {
        return quantity >= eligibleQuantity;
    }
}
