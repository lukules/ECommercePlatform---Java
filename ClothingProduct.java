public class ClothingProduct extends Product {
    private String size;
    private String color;

    public ClothingProduct(String productId, String name, double price, int stockQuantity) {
        super(productId, name, price, stockQuantity);

    }


    public String getProductDetails() {
        return "    Size: " + size + "  Color: " + color;
    }
}
