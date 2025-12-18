package structural;

interface Pizza {
    String getDescription();
    double getCost();
}

// ========= Concrete Component =========
class Margherita implements Pizza {
    @Override
    public String getDescription() {
        return "Margherita Pizza";
    }
    @Override
    public double getCost() {
        return 200.0;
    }
}

// ========= Decorator =========
abstract class PizzaDecorator implements Pizza {
    protected Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }
}

// ========= Concrete Decorators =========
class ExtraCheese extends PizzaDecorator {
    public ExtraCheese(Pizza pizza) {
        super(pizza);
    }
    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Extra Cheese";
    }
    @Override
    public double getCost() {
        return pizza.getCost() + 50.0;
    }
}

class Olives extends PizzaDecorator {
    public Olives(Pizza pizza) {
        super(pizza);
    }
    @Override
    public String getDescription() {
        return pizza.getDescription() + ", Olives";
    }
    @Override
    public double getCost() {
        return pizza.getCost() + 30.0;
    }
}


public class DecoratorPattern {
    public static void main(String[] args) {
        Pizza pizza = new ExtraCheese(new Margherita());
        Pizza pizzaWithOlives = new Olives(pizza);
        System.out.println("Description: " + pizza.getDescription());
        System.out.println("Cost: " + pizza.getCost());

        System.out.println("\n----------\nDescription: " + pizzaWithOlives.getDescription());
        System.out.println("Cost: " + pizzaWithOlives.getCost());
    }
}
