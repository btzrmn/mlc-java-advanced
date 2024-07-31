package class05.lab;

import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strArr = sc.nextLine().split(", ");
//        Function<String, Integer> parser = x -> Integer.parseInt(x);
        BiFunction<Integer, String, Integer> add = (x, y) -> x + Integer.parseInt(y);
        int sum = 0;
        for (String s : strArr) {
            sum = add.apply(sum, s);
        }
        System.out.printf("Count = %d%nSum = %d", strArr.length, sum);
    }
}
