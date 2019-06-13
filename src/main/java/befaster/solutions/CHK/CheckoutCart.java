/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author robert.damian
 */
public class CheckoutCart {
    private List<CheckoutItem> cartItems;
    
    public CheckoutCart() {
        this(Collections.EMPTY_LIST);
    }
    
    public CheckoutCart(Collection<CheckoutItem> items) {
        this.cartItems = new ArrayList<>(items);
    }
    
    public int getTotal() {
        return cartItems.stream().mapToInt(CheckoutItem::getTotal).sum();
    }
    
    public void addItem(CheckoutItem item) {
        this.cartItems.add(item);
    }
}
