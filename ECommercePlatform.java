import java.util.*;
import java.util.stream.Collectors;

public class ECommercePlatform {
    private HashMap<String, Product> products;
    private HashMap<String, User> users;
    private ArrayList<Order> orders;

    private int nextOrderId = 1;

    public ECommercePlatform() {
        this.products = new HashMap<>();
        this.users = new HashMap<>();
        this.orders = new ArrayList<>();
    }


    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    public void addProduct(Product product) {
        products.put(product.getProductId(), product);
    }

    public void displayProducts(){
        System.out.println("Avaiable products: \n");
        if(products.isEmpty()) {
            System.err.println("No products in the store...");
            return;
        }

        for(Product product : products.values()) {
            System.out.println(product);
        }
    }

    public User login(String username, String password) {
        User user = users.get(username);

        if(user != null && user.getPassword().equals(password)) {
            System.out.println("Successfully logged in as: " + username);
            return user;
        }
        System.err.println("Login failed: invalid username or password.");
        return null;
    }

    public Order createOrder(User user) {
        ShoppingCart cart = user.getCart();

        if(cart.getItems().isEmpty()) {
            System.err.println("Cannot place the order - your cart is empty!");
            return null;
        }

        for(Map.Entry<Product, Integer> entry: cart.getItems().entrySet()) {
            Product product = entry.getKey();
            int requiredQuantity = entry.getValue();
            if(product.getStockQuantity() < requiredQuantity) {
                System.err.println("ERROR: Insufficient stock for product: " + product.getName());
                return null;
            }
        }

        Order newOrder = new Order(nextOrderId, user, cart);
        orders.add(newOrder);
        nextOrderId++;

        for(Map.Entry<Product, Integer> entry : newOrder.getOrderedItems().entrySet()) {
            Product product = entry.getKey();
            int quantity = entry.getValue();
            product.decreaseStock(quantity);
        }

        cart.clearCart();

        System.out.println("Order #" + newOrder.getOrderId() + "has been placed successfully");
        return newOrder;
    }


    public List<Product> findProducts(String keyword) {
        return products.values().stream()
                .filter(p -> p.getName().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void sortProductsByPrice() {
        System.out.println("--- Products Sorted by Price ---");
        products.values().stream()
                .sorted(Comparator.comparing(Product::getPrice))
                .forEach(System.out::println);
    }


    public Map<String, Product> getProducts() { return products; }
    public Map<String, User> getUsers() { return users; }
    public ArrayList<Order> getOrders() { return orders; }



}
