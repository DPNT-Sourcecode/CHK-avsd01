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
    
    private CheckoutItemFactory INSTANCE;
    private Map<String, CheckoutItem> currentItemState;
    
    private CheckoutItemFactory() {
        resetFactory();
    }
    
    public final void resetFactory() {
        currentItemState = new HashMap<>();
    }
    
    public CheckoutItemFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CheckoutItemFactory();
        }
        
        return INSTANCE;
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
    public CheckoutItem getItemFor(String itemSKU) {
        if (currentItemState.containsKey(itemSKU)) {
            CheckoutItem result = currentItemState.get(itemSKU);
            result = result.getIncreasedCopy();
            currentItemState.put(itemSKU, result);
            return result;
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
}


