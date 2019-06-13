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
public class CheckoutSolutionTest {
    
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
     */
    
    @Test
    public void testSimpleCart() {
        int result = new CheckoutSolution().checkout("A B C D");
        Assert.assertEquals(115, result);
    }
    
    public void testCartWithOfferA() {
        int result = new CheckoutSolution().checkout("A A A B C D");
        Assert.assertEquals(195, result);
    }
    
    public void testCartWithOfferB() {
        int result = new CheckoutSolution().checkout("A B B C D");
        Assert.assertEquals(130, result);
    }
}
