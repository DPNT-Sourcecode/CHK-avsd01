package befaster.solutions.CHK;

public class CheckoutSolution {
    public Integer checkout(String skus) {
        CheckoutItemFactory factory = new CheckoutItemFactory();
        
        for(String itemSKU : skus.split(" ")) {
            factory.feedNewItem(itemSKU);
        }
        CheckoutCart resultCart = factory.exportCart();
        return resultCart.getTotal();
    }
}
