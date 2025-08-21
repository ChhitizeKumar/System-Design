package order;

public class User {

    public double x, y;
    public String name;
    public Cart cart;

    public User(String name, double x, double y) {
        this.x = x;
        this.y = y;
        this.name = name;
        cart = new Cart();
    }

    public Cart getCart() {
        return cart;
    }
}
