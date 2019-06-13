/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK;

import befaster.solutions.CHK.offers.SpecialOffer;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author robert.damian
 */
public class CheckoutCart implements SpecialOffer.SpecialOfferReceiver{
    private List<CheckoutItem> cartItems;
    private List<SpecialOffer> offerList;
    
    public CheckoutCart() {
        this(Collections.EMPTY_LIST);
    }
    
    public CheckoutCart(Collection<CheckoutItem> items) {
        this.cartItems = new ArrayList<>(items);
        offerList = new ArrayList<SpecialOffer>();
    }
    
    public void computeOffers() {
        cartItems.stream().forEach(i -> i.computeAllOffers(this));
    }
    
    public int getTotal() {
        return cartItems.stream().mapToInt(CheckoutItem::getTotal).sum();
    }
    
    public void addItem(CheckoutItem item) {
        this.cartItems.add(item);
    }

    @Override
    public void specialOfferReceived(SpecialOffer offer) {
        offerList.add(offer);
    }
}

