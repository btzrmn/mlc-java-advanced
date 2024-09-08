package oop01.exercise.PizzaCalories;

public class Topping {
    private static final double BASE_CALORIES = 2;
    private static final String MEAT = "Meat";
    private static final double MEAT_VAL = 1.2;
    private static final String VEGGIES = "Veggies";
    private static final double VEGGIES_VAL = 0.8;
    private static final String CHEESE = "Cheese";
    private static final double CHEESE_VAL = 1.1;
    private static final String SAUCE = "Sauce";
    private static final double SAUCE_VAL = 0.9;

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        boolean valid = toppingType.equals(MEAT) ||
                toppingType.equals(VEGGIES) ||
                toppingType.equals(CHEESE) ||
                toppingType.equals(SAUCE);
        if (!valid) {
            throw new IllegalArgumentException(String.format("Cannot place %s on top of your pizza.", toppingType));
        }
        this.toppingType = toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            throw new IllegalArgumentException(String.format("%s weight should be in the range [1..50].", this.toppingType));
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        return BASE_CALORIES * this.weight * this.getModifierValue(this.toppingType);
    }

    private double getModifierValue(String modifier) {
        double modifierValue = 0;
        switch (modifier) {
            case MEAT:
                modifierValue = MEAT_VAL;
                break;
            case VEGGIES:
                modifierValue = VEGGIES_VAL;
                break;
            case CHEESE:
                modifierValue = CHEESE_VAL;
                break;
            case SAUCE:
                modifierValue = SAUCE_VAL;
                break;
        }
        return modifierValue;
    }
}
