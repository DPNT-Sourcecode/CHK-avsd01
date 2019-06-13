/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK;

import befaster.solutions.CHK.discounts.DiscountPack;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author robert.damian
 */
public class CheckoutCart implements  
        DiscountPack.DiscountPackReceiver{
    private List<CheckoutItem> cartItems;
    private List<DiscountPack> discountPackList;
    
    public CheckoutCart() {
        this(Collections.EMPTY_LIST);
    }
    
    public CheckoutCart(Collection<CheckoutItem> items) {
        this.cartItems = new ArrayList<>(items);
        discountPackList = new ArrayList<>();
    }
    
    public void computeOffers() {
        cartItems.stream().forEach(i -> i.computeAllOffers(this));
    }
    
    public int getTotal() {
        computeOffers();
        discountPackList.stream()
                .sorted((d1,d2) -> d2.simulateImpactOnCart(this) -
                        d1.simulateImpactOnCart(this))
                .forEach(d -> 
                        d.applyToCartChecked(this));
        
        return cartItems.stream().mapToInt(CheckoutItem::getTotal).sum();
    }
    
    public int getTotalNoDiscounts() {
        return cartItems.stream().mapToInt(CheckoutItem::getTotal).sum();
    }
    
    public void addItem(CheckoutItem item) {
        this.cartItems.add(item);
    }
    
    public void replace(String itemSKU, int count, CheckoutItem item) {
        CheckoutItem matchingItem = getItemWithSKU(itemSKU);
        if (matchingItem == null) {
            return ;
        }
        
        cartItems.remove(matchingItem);
        matchingItem = matchingItem.getDecreasedCopy(count);
        
        cartItems.add(matchingItem);
        cartItems.add(item);
    }
    
    public CheckoutItem getItemWithSKU(String sku) {
        return cartItems.stream().filter(i -> sku.equals(i.getItemSKU()))
                .findAny().orElse(null);
    }

    @Override
    public void discountPackReceived(DiscountPack discoutPack) {
        discountPackList.add(discoutPack);
    }
    
    public CheckoutCart createCopy() {
        return new CheckoutCart(cartItems);
    }
}
