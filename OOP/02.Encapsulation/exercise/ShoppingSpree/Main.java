package oop01.exercise.ShoppingSpree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new HashMap<>();

        try {
            Arrays.stream(scanner.nextLine().split(";"))
                    .forEach(p -> {
                        String[] tokens = p.split("=");
                        Person person = new Person(tokens[0], Double.parseDouble(tokens[1]));
                        people.putIfAbsent(tokens[0], person);
                    });
            Arrays.stream(scanner.nextLine().split(";"))
                    .forEach(p -> {
                        String[] tokens = p.split("=");
                        Product product = new Product(tokens[0], Double.parseDouble(tokens[1]));
                        products.putIfAbsent(tokens[0], product);
                    });
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String command = scanner.nextLine();
        while (!command.equals("END")) {
            String[] tokens = command.split(" ");
            String personName = tokens[0];
            String productName = tokens[1];

            Person person = people.get(personName);
            Product product = products.get(productName);
            if (person == null || product == null) {
                continue;
            }
            try {
                person.buyProduct(product);
                System.out.printf("%s bought %s%n", personName, productName);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            command = scanner.nextLine();
        }

        people.values().forEach(p -> {
            StringBuilder str = new StringBuilder();
            if (p.getProducts().size() == 0) {
                str.append(String.format("%s – Nothing bought%n", p.getName()));
            } else {
                str.append(p.getName())
                        .append(" - ")
                        .append(p.getProducts().stream().map(product -> product.getName()).collect(Collectors.joining(", ")));
            }
            System.out.println(str.toString());
        });
    }
}
