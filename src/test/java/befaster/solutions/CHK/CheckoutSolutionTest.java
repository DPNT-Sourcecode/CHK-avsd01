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
        Our price table and offers: 
        +------+-------+------------------------+
        | Item | Price | Special offers         |
        +------+-------+------------------------+
        | A    | 50    | 3A for 130, 5A for 200 |
        | B    | 30    | 2B for 45              |
        | C    | 20    |                        |
        | D    | 15    |                        |
        | E    | 40    | 2E get one B free      |
        +------+-------+------------------------+
     */
    
    @Test
    public void testSimpleCart() {
        int result = new CheckoutSolution().checkout("ABCD");
        Assert.assertEquals(115, result);
    }
    
    @Test
    public void testCartWithOfferA() {
        int result = new CheckoutSolution().checkout("AAABCD");
        Assert.assertEquals(195, result);
    }
    
    @Test
    public void testCartWithOfferB() {
        int result = new CheckoutSolution().checkout("ABBCD");
        Assert.assertEquals(130, result);
    }
    
    @Test
    public void testEmptyCart() {
        int result = new CheckoutSolution().checkout("");
        Assert.assertEquals(0, result);
    }
    
    @Test
    public void testLowerCaseCart() {
        int result = new CheckoutSolution().checkout("aBCD");
        Assert.assertEquals(-1, result);
    }
    
    @Test
    public void testInvalidCart() {
        int result = new CheckoutSolution().checkout("-");
        Assert.assertEquals(-1, result);
    }
    
    @Test
    public void testUselessE() {
        int result = new CheckoutSolution().checkout("EE");
        Assert.assertEquals(80, result);
    }
    
    @Test
    public void testUsefulE() {
        int result = new CheckoutSolution().checkout("EEB");
        Assert.assertEquals(80, result);
    }
    
    @Test
    public void test5A() {
        int result = new CheckoutSolution().checkout("AAAAA");
        Assert.assertEquals(200, result);
    }
    
    @Test
    public void test8A() {
        int result = new CheckoutSolution().checkout("AAAAAAA");
        Assert.assertEquals(200, result);
    }
}

