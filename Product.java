public abstract class Product {
    private String productId;
    private String name;
    private double price;
    private int stockQuantity;

    public Product(String productId, String name, double price, int stockQuantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
    }

    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }


    public void decreaseStock(int quantity) {
        if(stockQuantity - quantity < 0) {
            System.err.println("Insufficient number of products in stock");
        }
        else stockQuantity -= quantity;
    }

    public void increaseStock(int quantity) {
        stockQuantity += quantity;
    }

    public abstract String getProductDetails();

    @Override
    public String toString(){
        return "PRODUCT ID:" + productId + "    |     PRODUCT NAME: " + name +
                "    |     PRICE: " + price + "    |     STOCK QUANTITY: " + stockQuantity;
    }




}
