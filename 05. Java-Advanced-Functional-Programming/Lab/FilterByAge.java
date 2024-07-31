package class05.lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, Integer> people = new LinkedHashMap<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] token = sc.nextLine().split(", ");
            people.put(token[0], Integer.parseInt(token[1]));
        }

        String condition = sc.nextLine();
        Integer age = Integer.parseInt(sc.nextLine());
        String format = sc.nextLine();
        Predicate<Integer> tester = createTester(condition, age);
        Consumer<Map.Entry<String,Integer>> printer = createConsumer(format);

        for(Map.Entry<String,Integer> person: people.entrySet()){
            if(tester.test(person.getValue())) {
                printer.accept(person);
            }
        }
    }

    private static Predicate<Integer> createTester(String condition, Integer age) {
        switch (condition) {
            case "younger":
                return x -> x <= age;
            case "older":
                return x -> x >= age;
            default:
                return null;
        }
    }

    private static Consumer<Map.Entry<String, Integer>> createConsumer(String format) {
        switch (format) {
            case "age":
                return person -> System.out.println(person.getValue());
            case "name":
                return person -> System.out.println(person.getKey());
            case "name age":
                return person -> System.out.printf("%s - %d%n",person.getKey(), person.getValue());
            default:
                return null;
        }
    }
}
