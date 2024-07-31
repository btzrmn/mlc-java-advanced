package class05.exercise;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindSmallestElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        Function<List<Integer>, Integer> smallestNumber = x -> {
            int n = x.stream().min(Integer::compareTo).get();
            return list.lastIndexOf(n);
        };

        System.out.println(smallestNumber.apply(list));
    }
}
