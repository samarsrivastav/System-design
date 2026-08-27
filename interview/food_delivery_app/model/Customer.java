package food_delivery_app.model;

public class Customer extends User {
    private Cart cart;

    public Customer() {
        super();
    }

    public Customer(String id, String name, String phone, Cart cart) {
        super(id, name, phone);
        this.cart = cart;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
