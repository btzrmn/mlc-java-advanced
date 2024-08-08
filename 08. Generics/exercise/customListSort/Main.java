package class08.excercise.customListSort;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomList<String> list = new CustomList<>();

        String input = sc.nextLine();
        while (!input.equals("END")) {
            String[] token = input.split("\\s+");
            switch (token[0]) {
                case "Add":
                    list.add(token[1]);
                    break;
                case "Remove":
                    list.remove(Integer.parseInt(token[1]));
                    break;
                case "Contains":
                    System.out.println(list.contains(token[1]));
                    break;
                case "Swap":
                    list.swap(Integer.parseInt(token[1]), Integer.parseInt(token[2]));
                    break;
                case "Greater":
                    System.out.println(list.countGreaterThan(token[1]));
                    break;
                case "Max":
                    System.out.println(list.getMax());
                    break;
                case "Min":
                    System.out.println(list.getMin());
                    break;
                case "Print":
                    list.print();
                    break;
                case "Sort":
                    Sorter.sort(list);
                    break;
            }
            input = sc.nextLine();
        }
    }
}
