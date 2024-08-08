package class08.excercise.genericSwapMethodInteger;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GenericList<Integer> list = new GenericList<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(sc.nextLine()));
        }
        String[] token = sc.nextLine().split("\\s+");
        list.swap(Integer.parseInt(token[0]), Integer.parseInt(token[1]));
        list.print();
    }
}
