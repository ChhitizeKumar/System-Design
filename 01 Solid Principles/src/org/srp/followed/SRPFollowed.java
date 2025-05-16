package org.srp.followed;
import java.util.ArrayList;
import java.util.List;

class Product{
    String name;
    Double price;

    public Product(String name, Double price){
        this.name = name;
        this.price = price;
    }
}

class ShoppingCart{
    private List<Product> products = new ArrayList<>();


    public void addProduct(Product product){
        products.add(product);
    }

    public double getTotalPrice(){
        double total = 0;
        for(Product product : products){
            total += product.price;
        }
        return total;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

class ShoppingCartPrinter{
    private ShoppingCart cart;
    public ShoppingCartPrinter(ShoppingCart cart){
        this.cart = cart;
    }

    public void printInvoice(){
        System.out.println("Shopping Cart Invoice:");
        for (Product p : cart.getProducts()) {
            System.out.println(p.name + " - Rs " + p.price);
        }
        System.out.println("Total: Rs " + cart.getTotalPrice());
    }
}

class ShoppingCartStorage{
    private ShoppingCart cart;
    public ShoppingCartStorage(ShoppingCart cart){
        this.cart = cart;
    }

    public void saveToDatabase() {
        System.out.println("Saving shopping cart to database...");
    }

}
public class SRPFollowed {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addProduct(new Product("Laptop", 50000.0));
        cart.addProduct(new Product("Laptop", 50000.0));

        ShoppingCartPrinter printer = new ShoppingCartPrinter(cart);
        printer.printInvoice();

        ShoppingCartStorage storage = new ShoppingCartStorage(cart);
        storage.saveToDatabase();

    }
}
