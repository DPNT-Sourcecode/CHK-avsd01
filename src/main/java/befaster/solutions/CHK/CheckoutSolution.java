package befaster.solutions.CHK;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        try {
            return checkoutUnsafe(skus);
        } catch (IllegalArgumentException ex) {
            return -1;
        }
    }
    
    public Integer checkoutUnsafe(String unsafeSkus) {
        CheckoutItemFactory factory = new CheckoutItemFactory();
        for(String itemSKU : unsafeSkus.split("")) {
            factory.feedNewItem(itemSKU);
        }
        CheckoutCart resultCart = factory.exportCart();
        return resultCart.getTotal();
    }
}
