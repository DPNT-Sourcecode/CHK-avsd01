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
        offerList.stream().map(o -> );
        
        return cartItems.stream().mapToInt(CheckoutItem::getTotal).sum();
    }
    
    public void addItem(CheckoutItem item) {
        this.cartItems.add(item);
    }

    @Override
    public void discountPackReceived(DiscountPack discoutPack) {
        discountPackList.add(discoutPack);
    }
}


