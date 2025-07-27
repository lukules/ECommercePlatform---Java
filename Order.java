import java.time.LocalDateTime;
import java.util.HashMap;

public class Order {
    private int orderId;
    private int userId;
    private HashMap<Product, Integer> orderedItems;
    private double totalAmount;
    private LocalDateTime orderDate;
    private OrderStatus status;

    public Order(int orderId, User user,  ShoppingCart cart) {
        this.orderId = orderId;
        this.userId = user.getUserId();
        this.orderedItems = new HashMap<>(cart.getItems());
        this.totalAmount = cart.calculateTotal();
        this.orderDate = LocalDateTime.now();
        this.status = OrderStatus.PENDING;

    }

    public int getOrderId() {
        return orderId;
    }

    public int getUserId() {
        return userId;
    }

    public HashMap<Product, Integer> getOrderedItems() {
        return orderedItems;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void updateStatus(OrderStatus status) {
        this.status = status;
    }




}
