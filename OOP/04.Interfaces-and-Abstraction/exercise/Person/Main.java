package oop04.exercise.Person;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Birthable> birthableList = new ArrayList<>();

        String input = scanner.nextLine();

        Birthable birthable;

        while (!input.equals("End")) {
            String[] tokens = input.split(" ");
            String type = tokens[0];
            switch (type) {
                case "Citizen":
                    birthable = new Citizen(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
                    birthableList.add(birthable);
                    break;
                case "Pet":
                    birthable = new Pet(tokens[1], tokens[2]);
                    birthableList.add(birthable);
                    break;
            }
            input = scanner.nextLine();
        }

        String search = scanner.nextLine();
        List<String> list = birthableList.stream().map(Birthable::getBirthDate).filter(p -> p.endsWith(search)).collect(Collectors.toList());
        if (list.isEmpty()) {
            System.out.println("<no output>");
        } else {
            list.forEach(e -> System.out.println(e));
        }
    }
}
