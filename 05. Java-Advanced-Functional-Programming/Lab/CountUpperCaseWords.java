package class05.lab;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

public class CountUpperCaseWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] words = sc.nextLine().split("\\s+");
        Predicate<String> isUpperWord = s -> Character.isUpperCase(s.charAt(0));
        List<String> list = new ArrayList<>();
        for (String word : words) {
            if (isUpperWord.test(word)) {
                list.add(word);
            }
        }
        System.out.println(list.size());
        list.forEach(System.out::println);
    }
}
