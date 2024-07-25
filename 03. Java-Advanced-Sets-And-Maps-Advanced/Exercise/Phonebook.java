package class03.exercise;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> phonebook = new HashMap<>();

        String input = sc.nextLine();
        while (!input.equals("search")) {
            String[] token = input.split("-");
            phonebook.put(token[0], token[1]);
            input = sc.nextLine();
        }

        input = sc.nextLine();
        while (!input.equals("stop")) {
            if (phonebook.containsKey(input)) {
                System.out.println(input + " -> " + phonebook.get(input));
            } else {
                System.out.println("Contact " + input + " does not exist.");
            }
            input = sc.nextLine();
        }
    }
}
