package class06.exercise.carSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> engines = new HashMap<>();
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            insertEngines(engines, tokens);
        }

        int m = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < m; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            insertCars(cars, engines, tokens);
        }

        cars.forEach(System.out::println);
    }

    private static void insertEngines(Map<String, Engine> engines, String[] tokens) {
        String model = tokens[0];
        int power = Integer.parseInt(tokens[1]);
        Engine engine = null;
        switch (tokens.length) {
            case 2:
                engine = new Engine(model, power);
                break;
            case 3:
                if (tokens[2].matches("\\d+")) {
                    int displacement = Integer.parseInt(tokens[2]);
                    engine = new Engine(model, power, displacement);
                } else {
                    String efficiency = tokens[2];
                    engine = new Engine(model, power, efficiency);
                }
                break;
            case 4:
                int displacement = Integer.parseInt(tokens[2]);
                String efficiency = tokens[3];
                engine = new Engine(model, power, displacement, efficiency);
                break;
        }
        engines.putIfAbsent(model, engine);
    }

    private static void insertCars(List<Car> cars, Map<String, Engine> engines, String[] tokens) {
        String model = tokens[0];
        String engineModel = tokens[1];
        Engine engine = engines.get(engineModel);

        Car car = null;
        switch (tokens.length) {
            case 2:
                car = new Car(model, engine);
                break;
            case 3:

                if (tokens[2].matches("\\d+")) {
                    int weight = Integer.parseInt(tokens[2]);
                    car = new Car(model, engine, weight);
                } else {
                    String color = tokens[2];
                    car = new Car(model, engine, color);
                }
                break;
            case 4:
                int weight = Integer.parseInt(tokens[2]);
                String color = tokens[3];
                car = new Car(model, engine, weight, color);
                break;
        }
        cars.add(car);
    }
}
