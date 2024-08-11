package class09.exercise.Collection;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListyIterator<String> list = null;
        String input = sc.nextLine();
        while (!input.equals("END")) {
            String[] token = input.split(" ");
            switch (token[0]) {
                case "Create":
                    if (token.length > 1) {
                        list = new ListyIterator<>(Arrays.copyOfRange(token, 1, token.length));
                    } else {
                        list = new ListyIterator<>();
                    }
                    break;
                case "Move":
                    System.out.println(list.move());
                    break;
                case "HasNext":
                    System.out.println(list.hasNext());
                    break;
                case "Print":
                    try {
                        list.print();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "PrintAll":
                    list.printAll();
                    break;
            }
            input = sc.nextLine();
        }
    }
}
