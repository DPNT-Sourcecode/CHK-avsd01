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
    protected final int price;
    
    public CheckoutItem(int quantity, int price) {
        this.quantity = quantity;
        this.price = price;
    }
    
    public int getTotal() {
        return price * quantity;
    }
}


