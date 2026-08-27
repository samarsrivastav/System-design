package food_delivery_app.services;
import java.util.List;

import food_delivery_app.model.OrderStatus;
import food_delivery_app.model.Restaurant;
import food_delivery_app.repository.RestaurantRepository;

public class RestaurantService {
    private RestaurantRepository restaurantRepository;
    private OrderService orderService;
    public RestaurantService() {
        restaurantRepository = new RestaurantRepository();
        orderService = new OrderService();
    }

    public void registerRestaurant(Restaurant restaurant) {
        restaurantRepository.addRestaurant(restaurant);
    }

    public List<Restaurant> browseRestaurants() {
        return restaurantRepository.getRestaurants();
    }
    public void updateOrderStatus(OrderStatus status) {
        orderService.updateOrderStatus(status.name());
    }
}
