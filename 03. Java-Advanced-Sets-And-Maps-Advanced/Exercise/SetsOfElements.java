package class03.exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] inputs = sc.nextLine().split(" ");
        Set<String> nList = new LinkedHashSet<>();
        Set<String> mList = new LinkedHashSet<>();
        for (int i = 0; i < Integer.parseInt(inputs[0]); i++) {
            nList.add(sc.nextLine());
        }
        for (int i = 0; i < Integer.parseInt(inputs[1]); i++) {
            mList.add(sc.nextLine());
        }
        nList.retainAll(mList);
        System.out.println(String.join(" ", nList));
    }
}
