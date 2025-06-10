package managers;

import models.Order;

import java.util.ArrayList;
import java.util.List;

//Singleton Class
public class OrderManager {
    private List<Order> orderList = new ArrayList<>();
    private OrderManager orderManagerInstance = null;

    private OrderManager(){}

    public OrderManager getOrderManagerInstance() {

        if (orderManagerInstance == null)
            orderManagerInstance = new OrderManager();

        return orderManagerInstance;
    }

    public void addOrder(Order order)
    {
        orderList.add(order);
    }

    public void listOrders() {
        System.out.println("\n--- All Orders ---");
        for (Order order : orderList) {
            System.out.println(order.getType() + " order for " + order.getUser().getName()
                    + " | Total: ₹" + order.getTotal()
                    + " | At: " + order.getScheduled());
        }
    }

}
