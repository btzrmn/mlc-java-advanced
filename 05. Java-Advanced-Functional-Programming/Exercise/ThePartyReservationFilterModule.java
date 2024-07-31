package class05.exercise;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> names = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());
        HashMap<String, HashMap<String, Predicate<String>>> filters = new HashMap<>();

        String input = sc.nextLine();
        while (!input.equals("Print")) {
            String[] token = input.split(";");
            String command = token[0];
            String modifier = token[1];
            String value = token[2];
            Predicate<String> filter = createFilter(modifier, value);
            if (command.equals("Add filter")) {
                if (!filters.containsKey(modifier)) {
                    filters.put(modifier, new HashMap<>());
                }
                filters.get(modifier).put(value, filter);
            } else if (command.equals("Remove filter")) {
                if (filters.containsKey(modifier)) {
                    if (filters.get(modifier).containsKey(value)) {
                        filters.get(modifier).remove(value);
                    }
                }
            }
            input = sc.nextLine();
        }

        filter(names, filters);

        System.out.println(String.join(" ", names));
    }

    private static void filter(List<String> names, HashMap<String, HashMap<String, Predicate<String>>> filters) {
        for (Map.Entry<String, HashMap<String, Predicate<String>>> entry : filters.entrySet()) {
            for (Map.Entry<String, Predicate<String>> innerEntry : entry.getValue().entrySet()) {
                names.removeIf(innerEntry.getValue());
            }
        }
    }

    private static Predicate<String> createFilter(String modifier, String value) {
        Predicate<String> filter = null;
        switch (modifier) {
            case "Starts with":
                filter = x -> x.startsWith(value);
                break;
            case "Ends with":
                filter = x -> x.endsWith(value);
                break;
            case "Length":
                filter = x -> x.length() == Integer.parseInt(value);
                break;
            case "Contains":
                filter = x -> x.contains(value);
                break;
        }
        return filter;
    }
}
