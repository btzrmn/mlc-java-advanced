package class09.exercise.StackIterator;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CustomStack stack = new CustomStack();
        String input = sc.nextLine();
        while (!input.equals("END")) {
            String[] token = input.split("\\s+");
            switch (token[0]){
                case "Push":
                    for (int i = 1; i < token.length; i++) {
                        stack.push(Integer.parseInt(token[i].replace(",","")));
                    }
                    break;
                case "Pop":
                    stack.pop();
                    break;
            }
            input = sc.nextLine();
        }
        stack.forEachModified(System.out::println);
        stack.forEachModified(System.out::println);
    }
}
