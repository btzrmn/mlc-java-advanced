package class05.exercise;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.IntStream;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = Arrays.stream(sc.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Function<int[], int[]> increaseByOne = (int[] x) -> Arrays.stream(x).map(e -> e += 1).toArray();
        Function<int[], int[]> decreaseByOne = (int[] x) -> Arrays.stream(x).map(e -> e -= 1).toArray();
        Function<int[], int[]> multipleByTwo = (int[] x) -> Arrays.stream(x).map(e -> e *= 2).toArray();
        Consumer<int[]> printer = x -> Arrays.stream(x).forEach(e -> System.out.print(e + " "));

        String input = sc.nextLine();
        while (!input.equals("end")) {
            switch (input) {
                case "add":
                    numbers = increaseByOne.apply(numbers);
                    break;
                case "subtract":
                    numbers = decreaseByOne.apply(numbers);
                    break;
                case "multiply":
                    numbers = multipleByTwo.apply(numbers);
                    break;
                case "print":
                    printer.accept(numbers);
                    System.out.println();
                    break;
            }
            input = sc.nextLine();
        }
    }
}
