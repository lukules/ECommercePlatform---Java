public class ElectronicProduct extends Product {
    private int warrantyPeriod;

    public ElectronicProduct(String productId, String name, double price, int stockQuantity) {
        super(productId, name, price, stockQuantity);
    }


    public String getProductDetails(){
        return "Product's warranty period is equal to: " + warrantyPeriod + " months";
    }
}
