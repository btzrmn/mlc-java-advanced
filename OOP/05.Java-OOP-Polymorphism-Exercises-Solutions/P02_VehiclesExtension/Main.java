package vehiclesExtension;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");
        Car car = new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));

        tokens = scanner.nextLine().split("\\s+");
        Truck truck = new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));

        tokens = scanner.nextLine().split("\\s+");
        Bus bus = new Bus(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]), Double.parseDouble(tokens[3]));

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0) {
            tokens = scanner.nextLine().split("\\s+");


            try {
                switch (tokens[0]) {
                    case "Drive":
                        double distance = Double.parseDouble(tokens[2]);

                        if (tokens[1].equals("Car")) {
                            System.out.println(car.drive(distance));
                        } else if (tokens[1].equals("Truck")) {
                            System.out.println(truck.drive(distance));
                        } else {
                            bus.setIsEmpty(false);
                            System.out.println(bus.drive(distance));
                        }
                        break;
                    case "DriveEmpty":
                        distance = Double.parseDouble(tokens[2]);

                        System.out.println(bus.drive(distance));
                        break;
                    case "Refuel":
                        double liters = Double.parseDouble(tokens[2]);

                        if (tokens[1].equals("Car")) {
                            car.refuel(liters);
                        } else if (tokens[1].equals("Truck")) {
                            truck.refuel(liters);
                        } else {
                            bus.refuel(liters);
                        }
                        break;
                }
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
        System.out.println(bus.toString());
    }
}
