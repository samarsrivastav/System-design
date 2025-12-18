package structural;

import java.util.ArrayList;
import java.util.List;

interface CartItem {
    double getPrice();
    void display(String indent);
}

class Product implements CartItem {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "Product: " + name + ", Price: $" + price);
    }
}

class ProductBundle implements CartItem {
    private String bundleName;
    private List<CartItem> items;

    public ProductBundle(String bundleName) {
        this.bundleName = bundleName;
        this.items = new ArrayList<>();
    }

    public void addItem(CartItem item) {
        items.add(item);
    }

    @Override
    public double getPrice() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getPrice();
        }
        return total;
    }

    @Override
    public void display(String indent) {
        System.out.println(indent + "Bundle: " + bundleName + ", Total Price: $" + getPrice());
        for (CartItem item : items) {
            item.display(indent + "  ");
        }
    }
}

public class CompositePattern {
    public static void main(String[] args) {
        Product item1 = new Product("Laptop", 999.99);
        Product item2 = new Product("Mouse", 25.50);
        Product item3 = new Product("Keyboard", 45.00);

        ProductBundle bundle1 = new ProductBundle("Office Set");
        bundle1.addItem(item2);
        bundle1.addItem(item3);
        bundle1.display("");

        ProductBundle megaBundle = new ProductBundle("Mega Bundle");
        megaBundle.addItem(item1);
        megaBundle.addItem(bundle1);

        megaBundle.display("");
    }
}
