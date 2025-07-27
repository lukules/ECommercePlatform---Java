public class User {
    private int userId;
    private String username;
    private String password;
    private ShoppingCart cart;

    public User(int userId, String username, String password) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.cart = new ShoppingCart();
    }


    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public ShoppingCart getCart() {
        return cart;
    }


}
