package oop04.lab.BorderControl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<Identifiable> list = new ArrayList<>();
        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            if (tokens.length == 3) {
                Citizen citizen = new Citizen(tokens[2], tokens[0], Integer.parseInt(tokens[1]));
                list.add(citizen);
            } else {
                Robot robot = new Robot(tokens[1], tokens[0]);
                list.add(robot);
            }
            input = scanner.nextLine();
        }
        input = scanner.nextLine();

        final String idEnd = input;

        list.stream().filter(e -> e.getId().endsWith(idEnd)).forEach(e -> {
            System.out.println(e.getId());
        });
    }
}
