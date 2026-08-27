package food_delivery_app.repository;

import java.util.Map;

import food_delivery_app.model.Cart;
import food_delivery_app.model.Customer;

public class CartRepository {
    Map<String, Cart> customerCartMap; //customerId

    public CartRepository(Map<String, Cart> customerCartMap) {
        this.customerCartMap = customerCartMap; 
    }
    public void addCart(Customer customer, Cart cart) {
        customerCartMap.put(customer.getId(), cart);
    }
    public Cart getCart(Customer customer) {
        return customerCartMap.get(customer.getId());
    }
    public void clearCart(Customer customer) {
        customerCartMap.remove(customer.getId());
    }
}
