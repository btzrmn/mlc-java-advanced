package class01.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MaxElement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayDeque<Integer> stack = new ArrayDeque<>();
        TreeSet<Integer> container = new TreeSet<>();

        int limit = Integer.valueOf(sc.nextLine());

        for (int i = 0; i < limit; i++) {
            String[] line = sc.nextLine().split("\\s+");

            if (line.length > 1) {
                int val = Integer.parseInt(line[1]);
                stack.push(val);
                container.add(val);
            } else {
                if (line[0].equals("2")) {
                    container.remove(stack.pop());
                } else if (line[0].equals("3")) {
                    System.out.println(container.last());
                }
            }
        }
    }
}