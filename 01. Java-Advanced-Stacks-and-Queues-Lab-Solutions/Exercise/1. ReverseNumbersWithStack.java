package class01.exercise;

import java.util.ArrayDeque;
import java.util.Scanner;

public class ReverseNumbersWithStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] numbers = sc.nextLine().split("\\s+");

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (String number : numbers) {
            stack.push(Integer.valueOf(number));
        }
        for (Integer integer : stack) {
            System.out.printf("%s ", stack.pop());
        }
    }
}
