package strategy;

import managers.InventoryManager;

import java.util.Map;

public class WeeklyReplenishStrategy implements ReplenishStrategy{
    @Override
    public void replenish(InventoryManager manager, Map<Integer, Integer> items) {

        System.out.println("[WeeklyReplenish] Weekly replenishment triggered for inventory.");
        for(Map.Entry<Integer, Integer> it: items.entrySet()){

            manager.addStock(it.getKey(), it.getValue());
        }

    }
}
