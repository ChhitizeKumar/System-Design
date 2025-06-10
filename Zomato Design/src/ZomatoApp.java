import factories.OrderFactory;
import managers.RestaurantManager;
import models.*;
import services.NotificationService;
import strategies.PaymentStrategy;

import java.util.List;

public class ZomatoApp {

    public ZomatoApp() {
            initializeRestaurants();
    }

    public void initializeRestaurants()
    {
        Restaurant restaurant1 = new Restaurant("Bikaner", "Delhi");
        restaurant1.addMenuItem(new MenuItem("P1", "Chole Bhature", 120));
        restaurant1.addMenuItem(new MenuItem("P2", "Samosa", 15));

        Restaurant restaurant2 = new Restaurant("Haldiram", "Kolkata");
        restaurant2.addMenuItem(new MenuItem("P1", "Raj Kachori", 80));
        restaurant2.addMenuItem(new MenuItem("P2", "Pav Bhaji", 100));
        restaurant2.addMenuItem(new MenuItem("P3", "Dhokla", 50));

        Restaurant restaurant3 = new Restaurant("Saravana Bhavan", "Chennai");
        restaurant3.addMenuItem(new MenuItem("P1", "Masala Dosa", 90));
        restaurant3.addMenuItem(new MenuItem("P2", "Idli Vada", 60));
        restaurant3.addMenuItem(new MenuItem("P3", "Filter Coffee", 30));

        RestaurantManager restaurantManager = RestaurantManager.getRestaurantManagerInstance();

        restaurantManager.addRestaurant(restaurant1);
        restaurantManager.addRestaurant(restaurant2);
        restaurantManager.addRestaurant(restaurant3);

    }

    public List<Restaurant> searchRestaurant(String location)
    {
        return RestaurantManager.getRestaurantManagerInstance().searchByLocation(location);
    }

    public void selectRestaurant(User user, Restaurant restaurant)
    {
        Cart cart = user.getCart();
        cart.setRestaurant(restaurant);
    }

    public void addToCart(User user, String itemCode)
    {
        Cart cart = user.getCart();

        if(cart.getRestaurant() == null)
        {
            System.out.println("Please select a restaurant first.");
        }
        else{
            for(MenuItem item:cart.getRestaurant().getMenu())
            {
                if(item.getCode().equalsIgnoreCase(itemCode)){
                    cart.addToCart(item);
                    break;
                }
            }
        }
    }

    public Order checkout(User user, String orderType, PaymentStrategy paymentStrategy,
                          OrderFactory orderFactory)
    {
        if (user.getCart().isCartEmpty()) return null;

        Cart cart = user.getCart();
        Restaurant restaurant = cart.getRestaurant();
        List<MenuItem> items = cart.getItems();
        double totalCost = cart.totalCost();

        Order order = orderFactory.createOrder(user, cart, restaurant, items, paymentStrategy, totalCost, orderType);

        return order;
    }

    public void payForOrder(User user, Order order) {
        boolean isPaymentSuccess = order.processPayment();

        if (isPaymentSuccess) {
            NotificationService.notify(order);
            user.getCart().clearCart();
        }
    }

    public void printUserCart(User user) {
        System.out.println("Items in cart:");
        System.out.println("------------------------------------");
        for (MenuItem item : user.getCart().getItems()) {
            System.out.println(item.getCode() + " : " + item.getName() + " : ₹" + item.getPrice());
        }
        System.out.println("------------------------------------");
        System.out.println("Grand total : ₹" + user.getCart().totalCost());
    }


}
