/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK;

/**
 *
 * @author robert.damian
 */
public class CheckoutItem {
    protected final int quantity;
    protected final double price;
    
    public CheckoutItem(int quantity, double price) {
        this.quantity = quantity;
        this.price = price;
    }
    
    public double getTotal() {
        return price * quantity;
    }
}

