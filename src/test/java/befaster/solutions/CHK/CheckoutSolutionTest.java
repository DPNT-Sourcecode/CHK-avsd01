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
    public void testUsefulE2() {
        int result = new CheckoutSolution().checkout("EEEEB");
        Assert.assertEquals(160, result);
    }
    
    @Test
    public void testUsefulE3() {
        int result = new CheckoutSolution().checkout("EEEB");
        Assert.assertEquals(120, result);
    }
    
    @Test
    public void testUsefulE4() {
        int result = new CheckoutSolution().checkout("EEBB");
        Assert.assertEquals(110, result);
    }
    
    @Test
    public void test5A() {
        int result = new CheckoutSolution().checkout("AAAAA");
        Assert.assertEquals(200, result);
    }
    
    @Test
    public void test8A() {
        int result = new CheckoutSolution().checkout("AAAAAAAA");
        Assert.assertEquals(330, result);
    }
    
    @Test
    public void testF() {
        int result = new CheckoutSolution().checkout("FFF");
        Assert.assertEquals(20, result);
    }
    
    @Test
    public void testSimpleZ() {
        int result = new CheckoutSolution().checkout("ZZZ");
        Assert.assertEquals(45, result);
    }
    
    @Test
    public void test3Items() {
        int result = new CheckoutSolution().checkout("XYZ");
        Assert.assertEquals(45, result);
    }
    
    @Test
    public void test3Items2() {
        int result = new CheckoutSolution().checkout("XXZ");
        Assert.assertEquals(45, result);
    }
    
    @Test
    public void test3ItemsAndOthers() {
        int result = new CheckoutSolution().checkout("XYZST");
        Assert.assertEquals(85, result);
    }
    
    @Test
    public void test6Items() {
        int result = new CheckoutSolution().checkout("XYZSTX");
        Assert.assertEquals(90, result);
    }
    /**
     * 
        - {"method":"checkout","params":["ZZZS"],"id":"CHK_R5_144"}, expected: 65, got: 66
        - {"method":"checkout","params":["STXS"],"id":"CHK_R5_145"}, expected: 62, got: 65
        - {"method":"checkout","params":["STXZ"],"id":"CHK_R5_146"}, expected: 62, got: 65
     */
    
    @Test
    public void testSpecial4Items() {
        int result = new CheckoutSolution().checkout("ZZZS");
        Assert.assertEquals(65, result);
    }
    
    @Test
    public void testSpecial4Items2() {
        int result = new CheckoutSolution().checkout("STXS");
        Assert.assertEquals(62, result);
    }
    
    @Test
    public void testSpecial4Items3() {
        int result = new CheckoutSolution().checkout("STXZ");
        Assert.assertEquals(62, result);
    }
}
