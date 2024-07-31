package class05.lab;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strNumbers = sc.nextLine().split(", ");
        List<Integer> list = Arrays.stream(strNumbers)
                .map(Integer::parseInt).collect(Collectors.toList());
        list.removeIf(e -> e % 2 != 0);
        Consumer<List<Integer>> printer = str -> {
            System.out.println(
                    String.join(", ",
                            str.stream()
                                    .map(e -> e.toString()).collect(Collectors.toList())));
        };

        printer.accept(list);

        list.sort(Integer::compareTo);

        printer.accept(list);
    }

    public String intToString(Integer x) {
        return x.toString();
    }
}
