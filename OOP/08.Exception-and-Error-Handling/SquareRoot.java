package oop08;

import java.util.Scanner;

public class SquareRoot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            int n = Integer.parseInt(sc.nextLine());
            if (n < 0) {
                throw new IllegalArgumentException("Invalid");
            }
            System.out.printf("%.2f%n", Math.sqrt(n));
        } catch (NumberFormatException e) {
            System.out.println("not number");
        }catch (IllegalArgumentException e) {
            System.out.println("Invalid");
        } finally {
            System.out.println("Goodbye");
        }
    }
}
