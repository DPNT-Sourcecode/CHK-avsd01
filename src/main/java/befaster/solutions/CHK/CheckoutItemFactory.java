/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK;

import befaster.solutions.CHK.discounts.OtherItemDiscountPack;
import befaster.solutions.CHK.offers.OtherFreeProductOffer;
import befaster.solutions.CHK.offers.PriceDiscountOffer;
import befaster.solutions.CHK.offers.PriceGroupDiscountOffer;
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
   +------+-------+------------------------+
    | Item | Price | Special offers         |
    +------+-------+------------------------+
    | A    | 50    | 3A for 130, 5A for 200 |
    | B    | 30    | 2B for 45              |
    | C    | 20    |                        |
    | D    | 15    |                        |
    | E    | 40    | 2E get one B free      |
    | F    | 10    | 2F get one F free      |
    | G    | 20    |                        |
    | H    | 10    | 5H for 45, 10H for 80  |
    | I    | 35    |                        |
    | J    | 60    |                        |
    | K    | 80    | 2K for 150             |
    | L    | 90    |                        |
    | M    | 15    |                        |
    | N    | 40    | 3N get one M free      |
    | O    | 10    |                        |
    | P    | 50    | 5P for 200             |
    | Q    | 30    | 3Q for 80              |
    | R    | 50    | 3R get one Q free      |
    | S    | 30    |                        |
    | T    | 20    |                        |
    | U    | 40    | 3U get one U free      |
    | V    | 50    | 2V for 90, 3V for 130  |
    | W    | 20    |                        |
    | X    | 90    |                        |
    | Y    | 10    |                        |
    | Z    | 50    |                        |
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
            case "F":
                return new CheckoutItem(itemSKU, 1, 10, new PriceDiscountOffer(3, 20));
            case "G":
                return new CheckoutItem(itemSKU, 1, 20);
            case "H":
                return new CheckoutItem(itemSKU, 1, 10, new PriceDiscountOffer(5, 45),
                        new PriceDiscountOffer(10, 80));
            case "I":
                return new CheckoutItem(itemSKU, 1, 35);
            case "J":
                return new CheckoutItem(itemSKU, 1, 60);
            case "K":
                return new CheckoutItem(itemSKU, 1, 70, new PriceDiscountOffer(2, 120));
            case "L":
                return new CheckoutItem(itemSKU, 1, 90);                
            case "M":
                return new CheckoutItem(itemSKU, 1, 15);                
            case "N":
                return new CheckoutItem(itemSKU, 1, 40, new OtherFreeProductOffer(3, 
                        new OtherItemDiscountPack("M", 1)));
            case "O":
                return new CheckoutItem(itemSKU, 1, 10);                
            case "P":
                return new CheckoutItem(itemSKU, 1, 50, new PriceDiscountOffer(5, 200));
            case "Q":
                return new CheckoutItem(itemSKU, 1, 30, new PriceDiscountOffer(3, 80));
            case "R":
                return new CheckoutItem(itemSKU, 1, 50, new OtherFreeProductOffer(3, 
                        new OtherItemDiscountPack("Q", 1)));
            case "S":
                return new CheckoutItem(itemSKU, 1, 20, new PriceGroupDiscountOffer("STXYZ", 3, 45));
            case "T":
                return new CheckoutItem(itemSKU, 1, 20, new PriceGroupDiscountOffer("STXYZ", 3, 45));
            case "U":
                return new CheckoutItem(itemSKU, 1, 40, new PriceDiscountOffer(4, 120));
            case "V":
                return new CheckoutItem(itemSKU, 1, 50, 
                        new PriceDiscountOffer(2, 90), 
                        new PriceDiscountOffer(3, 130));
            case "W":
                return new CheckoutItem(itemSKU, 1, 20);
            
            case "X":
                return new CheckoutItem(itemSKU, 1, 17, new PriceGroupDiscountOffer("STXYZ", 3, 45));
            case "Y":
                return new CheckoutItem(itemSKU, 1, 20, new PriceGroupDiscountOffer("STXYZ", 3, 45));
            case "Z":
                return new CheckoutItem(itemSKU, 1, 21, new PriceGroupDiscountOffer("STXYZ", 3, 45));
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
