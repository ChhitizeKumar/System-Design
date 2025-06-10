import factories.OrderNowOrderFactory;
import models.Cart;
import models.Order;
import models.Restaurant;
import models.User;
import strategies.UpiPaymentStrategy;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Simulating a happy flow
        // Create TomatoApp Object
        ZomatoApp tomato = new ZomatoApp();

        // Simulate a user coming in (Happy Flow)
        User user = new User(101, "Aditya", "Delhi");
        System.out.println("User: " + user.getName() + " is active.");

        user.setCart(new Cart());
        // User searches for restaurants by location
        List<Restaurant> restaurantList = tomato.searchRestaurant("Delhi");

        if (restaurantList.isEmpty()) {
            System.out.println("No restaurants found!");
            return;
        }

        System.out.println("Found Restaurants:");
        for (Restaurant restaurant : restaurantList) {
            System.out.println(" - " + restaurant.getName());
        }


        // User selects a restaurant
        tomato.selectRestaurant(user, restaurantList.get(0));
        System.out.println("Selected restaurant: " + restaurantList.get(0).getName());

        // User adds items to the cart
        tomato.addToCart(user, "P1");
        tomato.addToCart(user, "P2");

        tomato.printUserCart(user);

        // User checkout the cart
        Order order = tomato.checkout(user, "Delivery", new UpiPaymentStrategy("1234567890")
        , new OrderNowOrderFactory());

        // User pays for the cart. If payment is successful, notification is sent.
        tomato.payForOrder(user, order);
    }
}