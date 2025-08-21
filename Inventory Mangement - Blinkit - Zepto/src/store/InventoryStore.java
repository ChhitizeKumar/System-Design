package store;

import model.Product;

import java.util.List;

// It is like Repository
// @Repository
public interface InventoryStore {

    public void addProduct(Product product, int quantity);
    public void removeProduct(int sku, int quantity);
    public int checkStock(int sku);
    public List<Product> listAllProducts();
}
