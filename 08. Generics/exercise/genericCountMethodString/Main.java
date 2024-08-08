package class08.excercise.genericCountMethodString;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GenericList<String> list = new GenericList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }
        System.out.println(list.sumOfGreater(sc.nextLine()));
    }
}
