package oop08;

import java.util.Scanner;

public class NumberInRange {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split(" ");
        int min = Integer.parseInt(tokens[0]);
        int max = Integer.parseInt(tokens[1]);
        while (true) {
            String input = sc.nextLine();
            try {
                int num = Integer.parseInt(input);
                if (min <= num && num <= max) {
                    System.out.printf("Valid number: %d%n", num);
                    break;
                }
                throw new IllegalArgumentException("Invalid number: " + input);
            } catch (IllegalArgumentException e) {
                System.out.printf("Invalid number: %s%n", input);
            }
        }
    }
}
