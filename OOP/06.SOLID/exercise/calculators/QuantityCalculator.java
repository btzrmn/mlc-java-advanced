package oop06.exercise.calculators;

import oop06.exercise.products.Product;
import oop06.exercise.products.drink.Drink;
import oop06.exercise.products.food.Food;

import java.util.List;

public class QuantityCalculator implements Calculator {

    @Override
    public double sum(List<Product> products) {
        double sum = 0.0;
        for (Product product : products) {
            if (product instanceof Drink) {
                Drink drink = (Drink) product;
                sum = sum + drink.getDensity() * drink.getLitters();
            } else if (product instanceof Food) {
                sum += ((Food) product).getKilograms();
            }
        }
        return sum;
    }

    @Override
    public double average(List<Product> products) {
        return sum(products) / products.size();
    }
}
