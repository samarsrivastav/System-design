package food_delivery_app_2.managers;

import java.util.List;

import food_delivery_app_2.model.Restraunt;;

public class RestaurantManager {
    //singleton class to manage restaurants
    private List<Restraunt> restaurants;
    private static RestaurantManager instance;

    public static RestaurantManager getInstance() {
        if (instance == null) {
            instance = new RestaurantManager();
        }
        return instance;
    }
    
    public void addRestaurant(Restraunt restaurant) {
        restaurants.add(restaurant);
    }
    
    public List<Restraunt> getRestaurantsByLocation(String location) {
        return restaurants.stream()
                .filter(restaurant -> restaurant.getAddress().equals(location))
                .toList();
    }
}
