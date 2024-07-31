package class05.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> guests = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());

        String input = sc.nextLine();
        while (!input.equals("Party!")) {
            String[] token = input.split(" ");
            modifyList(token[0], guests, createFilter(token[1], token[2]));
            input = sc.nextLine();
        }

        if (!guests.isEmpty()) {
            guests = guests.stream().sorted().collect(Collectors.toList());
            System.out.println(String.join(", ", guests) + " are going to the party!");
        } else {
            System.out.println("Nobody is going to the party!");
        }
    }

    private static void modifyList(String command, List<String> guests, Predicate<String> filter) {
        switch (command) {
            case "Remove":
                guests.removeIf(filter);
                break;
            case "Double":
                for (int i = 0; i < guests.size(); i++) {
                    if (filter.test(guests.get(i))) {
                        guests.add(i, guests.get(i));
                        i++;
                    }
                }
                break;
        }
    }

    private static Predicate<String> createFilter(String command, String value) {
        Predicate<String> filter = null;
        switch (command) {
            case "StartsWith":
                filter = x -> x.startsWith(value);
                break;
            case "EndsWith":
                filter = x -> x.endsWith(value);
                break;
            case "Length":
                filter = x -> x.length() == Integer.parseInt(value);
                break;
        }
        return filter;
    }
}
