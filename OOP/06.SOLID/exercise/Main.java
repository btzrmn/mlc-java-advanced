package oop06.exercise;

import oop06.exercise.calculators.Calculator;
import oop06.exercise.calculators.CalorieCalculator;
import oop06.exercise.calculators.QuantityCalculator;
import oop06.exercise.products.Product;
import oop06.exercise.products.drink.Coke;
import oop06.exercise.products.drink.Lemonade;
import oop06.exercise.products.food.Chips;
import oop06.exercise.products.food.Chocolate;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
                new Coke(100),
                new Lemonade(100),
                new Chocolate(100),
                new Chips(100)
        );

        Calculator calorieCalculator = new CalorieCalculator();
        Printer printer = new Printer(calorieCalculator);
        printer.printSum(products);
    }
}
