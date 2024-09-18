package vehicles;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] tokens = scanner.nextLine().split("\\s+");

        Car car = new Car(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));

        tokens = scanner.nextLine().split("\\s+");

        Truck truck = new Truck(Double.parseDouble(tokens[1]), Double.parseDouble(tokens[2]));

        int n = Integer.parseInt(scanner.nextLine());

        while (n-- > 0){
            tokens = scanner.nextLine().split("\\s+");

            switch (tokens[0]){
                case "Drive":
                    if(tokens[1].equals("Car")){
                        System.out.println(car.drive(Double.parseDouble(tokens[2])));
                    }else{
                        System.out.println(truck.drive(Double.parseDouble(tokens[2])));
                    }
                    break;
                case "Refuel":
                    if(tokens[1].equals("Car")){
                        car.refuel(Double.parseDouble(tokens[2]));
                    }else{
                        truck.refuel(Double.parseDouble(tokens[2]));
                    }
                    break;
            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());
    }
}
