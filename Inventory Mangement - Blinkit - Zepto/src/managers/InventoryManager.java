package managers;

import model.Product;
import model.ProductFactory;
import store.DBInventoryStore;
import store.InventoryStore;

import java.util.List;

public class InventoryManager {

    private InventoryStore inventoryStore;

    public InventoryManager(InventoryStore inventoryStore) {
        this.inventoryStore = inventoryStore;
    }

    public void addStock(int sku, int quantity){

        Product product = ProductFactory.createProduct(sku);

        inventoryStore.addProduct(product, quantity);
        System.out.println("[InventoryManager] Added SKU " + sku + " Qty " + quantity);
    }

    public void removeStock(int sku, int quantity){
        inventoryStore.removeProduct(sku, quantity);
    }

    public int checkStock(int sku){
        return inventoryStore.checkStock(sku);
    }

    public List<Product> getAvailableProducts() {
        return inventoryStore.listAllProducts();
    }

}
