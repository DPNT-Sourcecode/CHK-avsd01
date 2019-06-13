/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package befaster.solutions.CHK.discounts;

/**
 *
 * @author robert.damian
 */
public class DiscountPack {
    private final int itemCount;
    private final int price;
    
    public DiscountPack(int itemCount, int price) {
        this.itemCount = itemCount;
        this.price = price;
    }

    public int getItemCount() {
        return itemCount;
    }

    public int getPrice() {
        return price;
    }
   
}
