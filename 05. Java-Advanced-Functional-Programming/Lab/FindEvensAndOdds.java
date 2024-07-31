package class05.lab;

import java.util.Scanner;
import java.util.function.Predicate;

public class FindEvensAndOdds {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] token = sc.nextLine().split("\\s+");
        String str = sc.nextLine();
        Predicate<Integer> condition;
        if (str.equals("even")) {
            condition = x -> x % 2 == 0;
        } else {
            condition = x -> x % 2 != 0;
        }
        int start = Integer.parseInt(token[0]);
        int end = Integer.parseInt(token[1]);
        for (int i = start; i <= end; i++) {
            if(condition.test(i)){
                System.out.printf("%d ", i);
            }
        }
    }
}
