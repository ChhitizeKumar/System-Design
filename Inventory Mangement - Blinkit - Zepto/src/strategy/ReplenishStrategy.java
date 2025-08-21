package strategy;

import managers.InventoryManager;

import java.util.Map;

public interface ReplenishStrategy {

    public void replenish(InventoryManager manager, Map<Integer, Integer> items);
}
