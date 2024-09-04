package class11.lab;

import java.util.Scanner;

public class RhombusOfStars {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 1; i <= n; i++) {
            printRow(n, i);
        }

        for (int i = n - 1; i > 0; i--) {
            printRow(n, i);
        }
    }

    static void printRow(int n, int count) {
        for (int i = 0; i < n - count; i++) {
            System.out.print(" ");
        }
        for (int i = 1; i < count; i++) {
            System.out.print("* ");
        }
        System.out.println("*");
    }
}
