package class01.exercise;

import java.util.Scanner;

public class RecursiveFibonacci {

    public static long[] memory;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        memory = new long[n + 1];

        long result = calcFibonacci(n);

        System.out.println(result);
    }

    private static long calcFibonacci(int n) {
        if (n < 2) {
            return 1;
        }

        if (memory[n] != 0) {
            return memory[n];
        }

        return memory[n] = calcFibonacci(n - 1) + calcFibonacci(n - 2);
    }
}
