/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK;

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
        +------+-------+----------------+
        | Item | Price | Special offers |
        +------+-------+----------------+
        | A    | 50    | 3A for 130     |
        | B    | 30    | 2B for 45      |
        | C    | 20    |                |
        | D    | 15    |                |
        +------+-------+----------------+
     * @param itemSKU
     * @return 
     */
    private CheckoutItem getItemFor(String itemSKU) {
        if (currentItemState.containsKey(itemSKU)) {
            return currentItemState.get(itemSKU).getIncreasedCopy();
        }
        
        switch (itemSKU) {
            case "A":
                return new CheckoutItem(1, 50, new SpecialOffer(3, 130));
            case "B": 
                return new CheckoutItem(1, 30, new SpecialOffer(2, 45));
            case "C":
                return new CheckoutItem(1, 20);
            case "D":
                return new CheckoutItem(1, 15);
        }
        
        throw new IllegalArgumentException("Unexpected SKU");
    }
    
    public CheckoutItem feedNewItem(String itemSKU) {
        if ("".equals(itemSKU)) {
            return new CheckoutItem(0, 0);
        }
        
        CheckoutItem newItem = getItemFor(itemSKU);
        currentItemState.put(itemSKU, newItem);
        return newItem;
    }
    
    public CheckoutCart exportCart() {
        return new CheckoutCart(currentItemState.values());
    }
}
