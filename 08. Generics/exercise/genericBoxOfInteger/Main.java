package class08.excercise.genericBoxOfInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < n; i++) {
            Box<Integer> input = new Box<>(Integer.parseInt(sc.nextLine()));
            System.out.println(input);
        }
    }
}
