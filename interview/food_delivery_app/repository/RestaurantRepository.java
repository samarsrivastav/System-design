package food_delivery_app.repository;

import java.util.ArrayList;
import java.util.List;
import food_delivery_app.model.Restaurant;

public class RestaurantRepository {
    List<Restaurant> restaurants = new ArrayList<>();
    public void addRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }
    public List<Restaurant> getRestaurants() {
        return restaurants;
    }
}
