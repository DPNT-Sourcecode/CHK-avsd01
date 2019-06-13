/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK;

import befaster.solutions.CHK.offers.PriceDiscountOffer;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author robert.damian
 */
public class CheckoutItemTest {
    @Test
    public void testNormalItem() {
        CheckoutItem item = new CheckoutItem(5, 40);
        
        Assert.assertEquals(200, item.getTotal());
    }
    
    @Test
    public void testWithOffer() {
        CheckoutItem item = new CheckoutItem(5, 40, new PriceDiscountOffer(2, 70));
        
        Assert.assertEquals(180, item.getTotal());
    }
}
