package oop04.exercise.Rebel;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Buyer> buyers = new LinkedHashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] tokens = scanner.nextLine().split(" ");
            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            if (tokens.length == 4) {
                Citizen citizen = new Citizen(name, age, tokens[2], tokens[3]);
                buyers.putIfAbsent(name, citizen);
            } else {
                Rebel rebel = new Rebel(name, age, tokens[2]);
                buyers.putIfAbsent(name, rebel);
            }
        }

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            Buyer buyer = buyers.get(input);
            if (buyer != null) {
                buyer.buyFood();
            }
            input = scanner.nextLine();
        }
        int sum = 0;
        for (Map.Entry<String, Buyer> entry : buyers.entrySet()) {
            sum += entry.getValue().getFood();
        }
        System.out.println(sum);
    }
}
