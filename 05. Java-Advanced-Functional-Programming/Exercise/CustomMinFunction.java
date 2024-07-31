package class05.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt).toArray();

        Function<int[], Integer> minInt = (x) -> Arrays.stream(x).min().getAsInt();

        System.out.println(minInt.apply(numbers));
    }
}
