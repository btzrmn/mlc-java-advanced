package oop01.exercise.PizzaCalories;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] pizzaTokens = scanner.nextLine().split(" ");
        String[] doughTokens = scanner.nextLine().split(" ");

        try {
            int numberOfToppings = Integer.parseInt(pizzaTokens[2]);
            Pizza pizza = new Pizza(pizzaTokens[1], numberOfToppings);
            Dough dough = new Dough(doughTokens[1], doughTokens[2], Double.parseDouble(doughTokens[3]));
            pizza.setDough(dough);
            for (int i = 0; i < numberOfToppings; i++) {
                String[] tokens = scanner.nextLine().split(" ");
                Topping topping = new Topping(tokens[1], Double.parseDouble(tokens[2]));
                pizza.addTopping(topping);
            }
            String input = scanner.nextLine();
            if (input.equals("END")) {
                System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
    }
}
