import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
    private HashMap<Product, Integer> items;

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public void addProduct(Product product, int quantity) {
        if(items.containsKey(product)) {
            int currentQuantity = items.get(product);
            int newQuantity = currentQuantity + quantity;

            items.put(product, newQuantity);
        }
        else {
            items.put(product, quantity);
        }
    }

    public void removeProduct(Product product) {
        if(items.containsKey(product)) {
            items.remove(product);
        }
        else System.err.println("There's no such product");
    }

    public double calculateTotal() {
        double totalPrice = 0.0d;

        for(Map.Entry<Product, Integer> entry : items.entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();

            totalPrice += product.getPrice() * quantity;
        }

        return totalPrice;

    }

    public void clearCart() {
        items.clear();
    }

    public void displayCart() {
        if (items.isEmpty()) {
            System.out.println("Your cart is empty!");
        }
        else {
            for(Map.Entry<Product, Integer> entry : items.entrySet()) {
                Product product = entry.getKey();
                int quantity = entry.getValue();

                System.out.println("Product: " + product.getName() + "  -   Quantity:" + quantity);

            }

        }
    }

    public HashMap<Product, Integer> getItems() {
        return items;
    }





}
