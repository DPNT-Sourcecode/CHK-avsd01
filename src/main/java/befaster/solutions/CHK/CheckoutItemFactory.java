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
public class CheckoutItemFactory {
    
    private CheckoutItemFactory INSTANCE;
    
    private CheckoutItemFactory() {
        
    }
    
    public CheckoutItemFactory getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CheckoutItemFactory();
        }
        
        return INSTANCE;
    }
    
    public static CheckoutItem getItemFor(String itemSKU) {
        
    }
}
