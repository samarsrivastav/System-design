package creational;

import java.util.List;

class BurgerMeal{
    //required
    private final String bunType;
    private final String pattyType;

    //optional
    private final boolean cheese;
    private final List<String> toppings;
    private final boolean hasFries;

    private BurgerMeal(BurgerMealBuilder builder){
        this.bunType = builder.bunType;
        this.pattyType = builder.pattyType;
        this.cheese = builder.cheese;
        this.toppings = builder.toppings;
        this.hasFries = builder.hasFries;
    }

    public static class BurgerMealBuilder{
        //required
        private final String bunType;
        private final String pattyType;

        //optional
        private boolean cheese;
        private List<String> toppings;
        private boolean hasFries;

        public BurgerMealBuilder(String bunType, String pattyType){
            this.bunType = bunType;
            this.pattyType = pattyType;
        }

        public BurgerMealBuilder addCheese(boolean cheese){
            this.cheese = cheese;
            return this;
        }

        public BurgerMealBuilder addToppings(List<String> toppings){
            this.toppings = toppings;
            return this;
        }

        public BurgerMealBuilder addFries(boolean hasFries){
            this.hasFries = hasFries;
            return this;
        }

        public BurgerMeal build(){
            return new BurgerMeal(this);
        }
    }

}
public class BuilderPattern {
    BurgerMeal meal = new BurgerMeal.BurgerMealBuilder("Whole Wheat", "Veggie")
            .addCheese(true)
            .addToppings(List.of("Lettuce", "Tomato", "Onion"))
            .addFries(true)
            .build();
            
}
