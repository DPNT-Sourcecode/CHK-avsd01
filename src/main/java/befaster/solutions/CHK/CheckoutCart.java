/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK;

import befaster.solutions.CHK.discounts.DiscountPack;
import befaster.solutions.CHK.offers.PriceGroupDiscountOffer;
import com.sun.jndi.url.iiop.iiopURLContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        
        String groupSKU = "STXYZ";
        PriceGroupDiscountOffer groupOffer = new PriceGroupDiscountOffer(groupSKU, 3, 45);
        
        List<CheckoutItem> matchingItems = getItemListForGroup(groupSKU);
        int matchingItemsAbsoluteCount = matchingItems.stream()
                .mapToInt(CheckoutItem::getItemQuantity)
                .sum();
        DiscountPack groupDiscount = groupOffer
                .computeOfferFor(groupSKU, matchingItemsAbsoluteCount);
        discountPackList.add(groupDiscount);
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
        if (itemSKU.length() > 1) {
            handleReplacementWithSKUGroup(itemSKU, count, item);
            return ; 
        }
            
        CheckoutItem matchingItem = getItemWithSKU(itemSKU);
        if (matchingItem == null) {
            return ;
        }
        
        cartItems.remove(matchingItem);
        matchingItem = matchingItem.getDecreasedCopy(count);
        
        cartItems.add(matchingItem);
        cartItems.add(item);
    }
    
    private void handleReplacementWithSKUGroup(String skuGroup, int count, 
            CheckoutItem item) {
        List<CheckoutItem> sortedMatchingList = getItemListForGroup(skuGroup);
        
        List<CheckoutItem> replacedList = new ArrayList<>();
        CheckoutItem partiallyReplacedItem = null;
        
        for (CheckoutItem i : sortedMatchingList) {
            if (i.getItemQuantity() < count) {
                replacedList.add(i);
                count -= i.getItemQuantity();
                continue;
            }
            
            partiallyReplacedItem = i;
        }
        
        if (partiallyReplacedItem == null) {
            return ;
        }
        
        cartItems.removeAll(replacedList);
        cartItems.remove(partiallyReplacedItem);
        partiallyReplacedItem = partiallyReplacedItem.getDecreasedCopy(count);
        cartItems.add(partiallyReplacedItem);
        cartItems.add(item);
        
    }
    
    private List<CheckoutItem> getItemListForGroup(String skuGroup) {
        return Stream.of(skuGroup.split(""))
                .map(sku -> getItemWithSKU(sku))
                .filter(i -> i != null)
                .sorted((i1, i2) -> 
                        i2.getPriceForSingleItem() - 
                        i1.getPriceForSingleItem())
                .collect(Collectors.toList());
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




