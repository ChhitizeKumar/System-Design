package factories;

import models.*;
import strategies.PaymentStrategy;
import utils.TimeUtils;

import java.util.List;

public class ScheduledOrderFactory implements OrderFactory{

    private String scheduleTime;

    public ScheduledOrderFactory(String scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

    @Override
    public Order createOrder(User user, Cart cart, Restaurant restaurant,
                             List<MenuItem> items, PaymentStrategy paymentStrategy,
                             double totalCost, String orderType) {

        Order order = null;

        if(orderType.equalsIgnoreCase("delivery"))
        {
            DeliveryOrder deliveryOrder = new DeliveryOrder();

            deliveryOrder.setDeliveryAddress(user.getAddress());
            order = deliveryOrder;
        }
        else{
            PickupOrder pickupOrder = new PickupOrder();
            pickupOrder.setRestaurantAddress(restaurant.getLocation());
            order = pickupOrder;
        }

        order.setItems(items);
        order.setUser(user);
        order.setRestaurant(restaurant);
        order.setPaymentStrategy(paymentStrategy);
        order.setTotal(totalCost);
        order.setScheduled(scheduleTime);

        return order;
    }
}
