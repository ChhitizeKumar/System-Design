package models;

public class User {
    private Integer userId;
    private String name;
    private String address;
    private Cart cart;

    public User() {
    }

    public User(Integer userId, String name, String address) {
        this.userId = userId;
        this.name = name;
        this.address = address;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public models.Cart getCart() {
        return cart;
    }

    public void setCart(models.Cart cart) {
        this.cart = cart;
    }
}
