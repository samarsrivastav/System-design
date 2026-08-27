package food_delivery_app.services;

import java.util.HashMap;
import java.util.List;

import food_delivery_app.model.Cart;
import food_delivery_app.model.CartItem;
import food_delivery_app.model.Customer;
import food_delivery_app.model.MenuItem;
import food_delivery_app.model.Restaurant;
import food_delivery_app.repository.CartRepository;

public class CustomerService {
    private static RestaurantService restaurantService;
    private static CartRepository cartRepository;
    public CustomerService() {
        restaurantService = new RestaurantService();
        cartRepository = new CartRepository(new HashMap<>());
    }

    public void browseRestaurants() {
        restaurantService.browseRestaurants().forEach(restaurant -> {
            System.out.println("Restaurant: " + restaurant.getName());
            restaurant.getMenuItems().forEach(menuItem -> {
                System.out.println(" - " + menuItem.getName() + ": $" + menuItem.getPrice());
            });
        });
    }

    public void addItemToCart(
        Customer customer,
        Restaurant restaurant,
        MenuItem menuItem,
        int quantity) {
            if(quantity <= 0) {
                throw new IllegalArgumentException("Quantity must be greater than 0");
            }
            if(menuItem == null) {
                throw new IllegalArgumentException("Menu item cannot be null");
            }

            CartItem cartItem = new CartItem(menuItem, quantity);

            List<CartItem> cartItems = List.of(cartItem);

            Cart cart = cartRepository.getCart(customer);

            if(cart == null) {
                cart = new Cart(cartItems, restaurant);
                cartRepository.addCart(customer, cart);
            }

            if(cart.getRestaurant().getId().equals(restaurant.getId())) {
                cart.addItem(cartItem);
            } else {
                // throw new IllegalArgumentException("Cannot add items from different restaurants to the same cart");
                // or 
                // clear the cart and add the new item
                cartRepository.clearCart(customer);
                cartRepository.addCart(customer, new Cart(List.of(cartItem), restaurant));
            }

        }
}
