package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Restaurant {
    private Integer restaurantId;
    private String name;
    private String location;
    private List<MenuItem> menu = new ArrayList<>();

    public Restaurant() {
    }

    public Restaurant(String name, String location) {
        this.name = name;
        this.location = location;
    }

    public void addMenuItem(MenuItem item)
    {
        menu.add(item);
    }

    public Integer getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Integer restaurantId) {
        this.restaurantId = restaurantId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }
}
