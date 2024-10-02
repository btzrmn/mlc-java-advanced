package oop06.exercise.products.food;

public abstract class BaseFood implements Food {
    private final double grams;
    private final double caloriesPer100Grams;

    protected BaseFood(double grams, double caloriesPer100Grams) {
        this.grams = grams;
        this.caloriesPer100Grams = caloriesPer100Grams;
    }

    public double getKilograms() {
        return this.grams / 1000.0;
    }

    public double getCalories() {
        return this.grams * this.caloriesPer100Grams / 100.0;
    }

}
