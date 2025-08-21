package managers;

import model.Product;
import store.DBInventoryStore;
import strategy.ReplenishStrategy;

import java.util.List;
import java.util.Map;

public class DarkStore {

    private InventoryManager inventoryManager;
    private String name;
    private double x, y;
    private ReplenishStrategy replenishStrategy;

    public DarkStore(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.replenishStrategy = null;
        inventoryManager = new InventoryManager(new DBInventoryStore());
    }

    public double distanceTo(double ux, double uy){

        return (x-ux)*(x-ux) + (y-uy)*(y-uy);
    }

    public void runReplenish(Map<Integer,Integer> items){
        if(replenishStrategy != null)
            replenishStrategy.replenish(inventoryManager, items);
    }

    public List<Product> getAllProducts(){
        return inventoryManager.getAvailableProducts();
    }

    public int checkStock(int sku) {
        return inventoryManager.checkStock(sku);
    }

    public void removeStock(int sku, int qty) {
        inventoryManager.removeStock(sku, qty);
    }

    public void addStock(int sku, int qty) {
        inventoryManager.addStock(sku, qty);
    }

    public InventoryManager getInventoryManager() {
        return inventoryManager;
    }

    public void setInventoryManager(InventoryManager inventoryManager) {
        this.inventoryManager = inventoryManager;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public ReplenishStrategy getReplenishStrategy() {
        return replenishStrategy;
    }

    public void setReplenishStrategy(ReplenishStrategy replenishStrategy) {
        this.replenishStrategy = replenishStrategy;
    }
}
