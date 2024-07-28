package class06.lab.problem1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        Car[] cars = new Car[n];

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            Car car;

            if (tokens.length == 1) {
                car = new Car(tokens[0]);
            } else {
                car = new Car(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
            }

            cars[i] = car;
        }

        for (Car car : cars) {
            System.out.println(car.carInfo());
        }
    }
}
