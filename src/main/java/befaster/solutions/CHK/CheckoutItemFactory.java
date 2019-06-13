/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK;

import befaster.solutions.CHK.discounts.OtherItemDiscountPack;
import befaster.solutions.CHK.offers.OtherFreeProductOffer;
import befaster.solutions.CHK.offers.PriceDiscountOffer;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author robert.damian
 */
public class CheckoutItemFactory {
    
    private Map<String, CheckoutItem> currentItemState;
    
    public CheckoutItemFactory() {
        resetFactory();
    }
    
    public final void resetFactory() {
        currentItemState = new HashMap<>();
    }
    
    /**
     * Our price table and offers: 
    +------+-------+------------------------+
    | Item | Price | Special offers         |
    +------+-------+------------------------+
    | A    | 50    | 3A for 130, 5A for 200 |
    | B    | 30    | 2B for 45              |
    | C    | 20    |                        |
    | D    | 15    |                        |
    | E    | 40    | 2E get one B free      |
    +------+-------+------------------------+
     * @param itemSKU
     * @return 
     */
    private CheckoutItem getItemFor(String itemSKU) {
        if (currentItemState.containsKey(itemSKU)) {
            return currentItemState.get(itemSKU).getIncreasedCopy();
        }
        
        switch (itemSKU) {
            case "A":
                return new CheckoutItem(itemSKU, 1, 50, 
                        new PriceDiscountOffer(3, 130), 
                        new PriceDiscountOffer(5, 200));
            case "B": 
                return new CheckoutItem(itemSKU, 1, 30, new PriceDiscountOffer(2, 45));
            case "C":
                return new CheckoutItem(itemSKU, 1, 20);
            case "D":
                return new CheckoutItem(itemSKU, 1, 15);
            case "E":
                return new CheckoutItem(itemSKU, 1, 40, new OtherFreeProductOffer(2, 
                        new OtherItemDiscountPack("B", 1)));
        }
        
        throw new IllegalArgumentException("Unexpected SKU");
    }
    
    public CheckoutItem feedNewItem(String itemSKU) {
        if ("".equals(itemSKU)) {
            return new CheckoutItem("free", 0, 0);
        }
        
        CheckoutItem newItem = getItemFor(itemSKU);
        currentItemState.put(itemSKU, newItem);
        return newItem;
    }
    
    public CheckoutCart exportCart() {
        return new CheckoutCart(currentItemState.values());
    }
}
