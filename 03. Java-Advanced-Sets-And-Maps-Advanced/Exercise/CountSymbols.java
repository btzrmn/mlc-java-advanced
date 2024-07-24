package class03.exercise;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        Map<Character, Integer> symbols = new TreeMap();

        for (int i = 0; i < input.length(); i++) {
            Character ch = input.charAt(i);
            if (!symbols.containsKey(ch)) {
                symbols.put(ch, 1);
            } else {
                int count = symbols.get(ch) + 1;
                symbols.put(ch, count);
            }
        }

        for (Character ch : symbols.keySet()) {
            System.out.printf("%c: %d time/s%n", ch, symbols.get(ch));
        }
    }
}
