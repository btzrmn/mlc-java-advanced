package class05.exercise;

import java.util.Scanner;
import java.util.function.Consumer;

public class KnightsOfHonor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split("\\s+");

        Consumer<String> printer = x -> System.out.println("Sir " + x);

        for (String word : words) {
            printer.accept(word);
        }
    }
}
