package class05.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class CustomComparator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = Arrays.stream(sc.nextLine().split("\\s+")).map(Integer::parseInt).collect(Collectors.toList());
        List<Integer> evenNumbers = numbers.stream().filter(x -> x % 2 == 0).sorted(Integer::compareTo).collect(Collectors.toList());
        List<Integer> oddNumbers = numbers.stream().filter(x -> x % 2 != 0).sorted(Integer::compareTo).collect(Collectors.toList());

        evenNumbers.forEach(x -> System.out.print(x + " "));
        oddNumbers.forEach(x -> System.out.print(x + " "));
    }
}
