package class06.exercise.speedRacing;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            Car car = new Car(tokens[0], Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));
            cars.putIfAbsent(tokens[0], car);
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split(" ");

            String model = tokens[1];
            int kilometer = Integer.parseInt(tokens[2]);

            Car car = cars.get(model);

            if (car.hasSufficient(kilometer)) {
                car.reduceFuel(kilometer);
                car.increaseDistance(kilometer);
            } else {
                System.out.println("Insufficient fuel for the drive");
            }
            input = scanner.nextLine();
        }

        cars.values().forEach(System.out::println);
    }
}
