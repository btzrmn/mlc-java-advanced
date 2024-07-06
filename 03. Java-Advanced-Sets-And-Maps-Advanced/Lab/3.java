package class02;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<Integer> set1 = getPlayerNumbers(scanner.nextLine().split(" "));
        LinkedHashSet<Integer> set2 = getPlayerNumbers(scanner.nextLine().split(" "));
        for (int i = 0; i < 50; i++) {
            Integer player1 = set1.iterator().next();
            set1.remove(player1);
            Integer player2 = set2.iterator().next();
            set2.remove(player2);
            if (player1 > player2) {
                set1.add(player1);
                set1.add(player2);
            } else {
                if (player2 > player1) {
                    set2.add(player1);
                    set2.add(player2);
                }
            }
            if (set1.isEmpty()) {
                break;
            }
            if (set2.isEmpty()) {
                break;
            }
        }
        if (set1.size() > set2.size()) {
            System.out.println("First player win!");
        }
        if (set2.size() > set1.size()) {
            System.out.println("Second player win!");
        }
        if (set2.size() == set1.size()) {
            System.out.println("Draw!");
        }
    }

    public static LinkedHashSet<Integer> getPlayerNumbers(String[] array) {
        LinkedHashSet<Integer> integerArray = new LinkedHashSet<>();
        for (int i = 0; i < array.length; i++) {
            integerArray.add(Integer.parseInt(array[i]));
        }
        return integerArray;
    }
}
