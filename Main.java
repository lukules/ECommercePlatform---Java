import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        System.out.println("--- Step 1: Initializing the E-Commerce Platform ---");
        ECommercePlatform platform = new ECommercePlatform();

        ElectronicProduct laptop = new ElectronicProduct("E001", "Gaming Laptop", 4500.00, 10);
        ClothingProduct tShirt = new ClothingProduct("C001", "Java Logo T-Shirt", 89.99, 50);
        ElectronicProduct mouse = new ElectronicProduct("E002", "Wireless Mouse", 120.00, 100);

        platform.addProduct(laptop);
        platform.addProduct(tShirt);
        platform.addProduct(mouse);

        User user1 = new User(1, "john.doe", "password123");
        platform.addUser(user1);

        System.out.println("\n--- Step 2: Visualizing initial platform state ---");
        displayPlatformState(platform);

        System.out.println("\n--- Step 3: Simulating User Login ---");
        User loggedInUser = platform.login("john.doe", "password123");
        platform.login("john.doe", "wrongpassword"); // Próba z błędnym hasłem

        System.out.println("\n--- Step 8: Testing Stream API methods ---");


        System.out.println("\nSearching for products with the keyword 'shirt':");
        List<Product> foundProducts = platform.findProducts("shirt");
        if (foundProducts.isEmpty()) {
            System.out.println("No products found.");
        } else {
            foundProducts.forEach(System.out::println);
        }

        System.out.println("\nSearching for products with the keyword 'game':");
        foundProducts = platform.findProducts("game");
        foundProducts.forEach(System.out::println);



        System.out.println("\nDisplaying all products sorted by price:");
        platform.sortProductsByPrice();


        // === SYMULACJA ZAKUPÓW ===
        if (loggedInUser != null) {
            System.out.println("\n--- Step 4: Simulating Shopping ---");
            ShoppingCart cart = loggedInUser.getCart();

            cart.addProduct(laptop, 1);
            System.out.println("Added 1x Laptop to cart.");

            cart.addProduct(tShirt, 2);
            System.out.println("Added 2x T-Shirt to cart.");

            cart.addProduct(tShirt, 1);
            System.out.println("Added 1x more T-Shirt to cart.");

            System.out.println("\nCurrent cart content:");
            cart.displayCart();

            System.out.println("\n--- Step 5: Visualizing ShoppingCart's internal HashMap ---");
            System.out.println("cart.getItems() raw view: " + cart.getItems());

            System.out.println("\n--- Step 6: Placing an order ---");
            platform.createOrder(loggedInUser);

            System.out.println("\n--- Step 7: Visualizing platform state AFTER order ---");
            displayPlatformState(platform);
        }
    }



    private static void displayPlatformState(ECommercePlatform platform) {
        System.out.println("================= PLATFORM STATE =================");

        System.out.println("\n[INFO] How the 'users' HashMap looks inside:");
        System.out.println(platform.getUsers());

        System.out.println("\n[INFO] How the 'products' HashMap looks inside:");
        System.out.println(platform.getProducts());

        System.out.println("\n[INFO] How the 'orders' ArrayList looks inside:");
        System.out.println(platform.getOrders());

        System.out.println("==================================================");
    }


}
