package class05.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class PredicateForName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n  = Integer.parseInt(sc.nextLine());

        List<String> names = Arrays.stream(sc.nextLine().split("\\s+")).collect(Collectors.toList());
        Predicate<String> isLessOrEqual = x -> x.length() <= n;

        names.stream().filter(isLessOrEqual).forEach(System.out::println);
    }
}
