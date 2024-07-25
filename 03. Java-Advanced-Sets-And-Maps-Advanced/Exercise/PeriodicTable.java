package class03.exercise;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class PeriodicTable {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Set<String> elements= new TreeSet<>();

        for (int i = 0; i < n; i++) {
            String[] inputElements = sc.nextLine().split(" ");
            for (String element: inputElements){
                elements.add(element);
            }
        }

        System.out.println(String.join(" ", elements));
    }
}
