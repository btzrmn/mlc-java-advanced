package oop08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class EnterNumber {
    private static int START = 1;
    private static int END = 100;
    private static Scanner scanner = new Scanner(System.in);
    private static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        while (numbers.size() < 10) {
            try {
                readNumber(START, END);
            } catch (NumberFormatException e) {
                System.out.println("Invalid Number!");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(numbers.stream().map(e -> e.toString()).collect(Collectors.joining(", ")));
    }
    private static void readNumber(int start, int end) {
        String input = scanner.nextLine();
        int num = Integer.parseInt(input);
        if (start < num && num < end) {
            numbers.add(num);
            START = num;
            return;
        }
        throw new IllegalArgumentException(String.format("Your number is not in range %d - 100!", START));
    }
}
