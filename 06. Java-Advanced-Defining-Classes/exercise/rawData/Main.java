package class06.exercise.rawData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            Engine engine = new Engine(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
            Cargo cargo = new Cargo(Integer.parseInt(tokens[3]), tokens[4]);
            String[] tiresTokens = Arrays.stream(tokens).skip(5).toArray(String[]::new);

            Car car = new Car(tokens[0], engine, cargo);
            for (int j = 0; j < tiresTokens.length; j += 2) {
                Tire tire = new Tire(Double.parseDouble(tiresTokens[j]), Integer.parseInt(tiresTokens[j + 1]));
                car.addTire(tire);
            }
            cars.add(car);
        }

        String cargoType = scanner.nextLine();

        if (cargoType.equals("fragile")) {
            cars.stream().filter(c -> c.getCargo().getType().equals(cargoType) && c.getTires().stream().anyMatch(t -> t.getPressure() < 1))
                    .map(c -> c.getModel())
                    .forEach(System.out::println);
        } else {
            cars.stream().filter(c -> c.getCargo().getType().equals(cargoType) && c.getEngine().getPower() > 250)
                    .map(c -> c.getModel())
                    .forEach(System.out::println);
        }
    }
}
