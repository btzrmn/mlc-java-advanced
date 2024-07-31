package class05.exercise;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = Arrays.stream(sc.nextLine().split("\\s+"))
                .map(Integer::parseInt).collect(Collectors.toList());

        int n = Integer.parseInt(sc.nextLine());

        Predicate<Integer> predicate = x -> x % n == 0;

        list.removeIf(predicate);
        Collections.reverse(list);
        System.out.println(String.join(" ", list.stream().map(e -> e.toString()).collect(Collectors.toList())));
    }
}
