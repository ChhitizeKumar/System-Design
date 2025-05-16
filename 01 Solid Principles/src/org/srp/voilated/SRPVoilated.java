package org.srp.voilated;

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
    List<Product> products = new ArrayList<>();

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

    public void printInvoice(){
        System.out.println("Shopping Cart Invoice:");
        for (Product p : products) {
            System.out.println(p.name + " - Rs " + p.price);
        }
        System.out.println("Total: Rs " + getTotalPrice());
    }

    public void saveToDatabase() {
        System.out.println("Saving shopping cart to database...");
    }

}

public class SRPVoilated {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addProduct(new Product("Laptop", 50000.0));
        cart.addProduct(new Product("Mouse", 2000.0));

        cart.printInvoice();
        cart.saveToDatabase();

    }
}
