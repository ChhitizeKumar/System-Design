package store;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBInventoryStore implements InventoryStore{

    private Map<Integer, Integer> stocks;
    private Map<Integer, Product> products;

    public DBInventoryStore(){
        stocks = new HashMap<>();
        products = new HashMap<>();
    }

    @Override
    public void addProduct(Product product, int quantity) {
        int sku = product.getSku();

        if(!products.containsKey(sku))
        {
            products.put(sku, product);
        }

        stocks.put(sku, stocks.getOrDefault(sku, 0) + quantity);
    }

    @Override
    public void removeProduct(int sku, int quantity) {

        if(!stocks.containsKey(sku))
            return;

        int currQuantity = stocks.get(sku);

        int remQuantity = currQuantity - quantity;

        if(remQuantity > 0){
            stocks.put(sku, remQuantity);
        }
        else{
            stocks.remove(sku);
            products.remove(sku);
        }
    }

    @Override
    public int checkStock(int sku) {

        return stocks.getOrDefault(sku, 0);
    }

    @Override
    public List<Product> listAllProducts() {

        List<Product> available = new ArrayList<>();

        for(Map.Entry<Integer, Integer> it:stocks.entrySet()){
            int sku = it.getKey();
            int qty = it.getValue();

            if(qty>0 && products.containsKey(sku)){
                available.add(products.get(sku));
            }
        }

        return available;
    }
}
