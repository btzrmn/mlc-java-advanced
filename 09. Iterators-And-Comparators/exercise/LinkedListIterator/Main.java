package class09.exercise.LinkedListIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedList<Integer> list = new LinkedList<>();
        int n = Integer.parseInt(sc.nextLine());

        for (int cycles = 0; cycles < n; cycles++) {
            String[] input = sc.nextLine().split("\\s+");

            switch (input[0]) {
                case "Add":
                    list.add(Integer.parseInt(input[1]));
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(input[1]));
                    break;
            }

        }

        System.out.println(list.getSize());
        System.out.println(list);
    }
}
