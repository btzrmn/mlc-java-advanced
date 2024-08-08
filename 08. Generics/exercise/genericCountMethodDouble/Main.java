package class08.excercise.genericCountMethodDouble;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GenericList<Double> list = new GenericList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            list.add(Double.parseDouble(sc.nextLine()));
        }
        System.out.println(list.sumOfGreater(Double.parseDouble(sc.nextLine())));
    }
}
