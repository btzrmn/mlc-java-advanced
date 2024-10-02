package oop06.exercise.products.drink;

public abstract class BaseDrink implements Drink {
    private final double milliliters;
    private final double caloriesPer100Grams;
    private final double density;

    protected BaseDrink(double milliliters, double caloriesPer100Grams, double density) {
        this.milliliters = milliliters;
        this.caloriesPer100Grams = caloriesPer100Grams;
        this.density = density;
    }

    @Override
    public double getCalories() {
        return this.milliliters * this.density * this.caloriesPer100Grams / 100.0;
    }

    @Override
    public double getLitters() {
        return this.milliliters / 1000.0;
    }

    @Override
    public double getDensity() {
        return this.density;
    }

}
