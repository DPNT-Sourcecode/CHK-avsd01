/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK;

import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author robert.damian
 */
public class CheckoutItemTest {
    @Test
    public void testNormalItem() {
        CheckoutItem item = new CheckoutItem("A", 5, 40);
        
        Assert.assertEquals(200, item.getTotal());
    }
}

