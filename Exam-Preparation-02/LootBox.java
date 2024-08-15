package examPreparation2;

import java.util.*;

public class LootBox {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> firstLoot = new ArrayDeque<>();
        Deque<Integer> secondLoot = new ArrayDeque<>();
        List<Integer> claimedItems = new ArrayList<>();

        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(e -> firstLoot.add(e));
        Arrays.stream(scanner.nextLine().split(" "))
                .map(Integer::parseInt).forEach(e -> secondLoot.push(e));

        while (!firstLoot.isEmpty() && !secondLoot.isEmpty()) {
            int first = firstLoot.peek();
            int second = secondLoot.peek();
            if ((first + second) % 2 == 0) {
                claimedItems.add(first + second);
                firstLoot.poll();
                secondLoot.pop();
            } else {
                firstLoot.add(secondLoot.pop());
            }
        }
        if (firstLoot.isEmpty()) {
            System.out.println("First lootbox is empty");
        } else {
            System.out.println("Second lootbox is empty");
        }

        int sum = claimedItems.stream().reduce(0, (x, y) -> x + y);
        if (sum >= 100) {
            System.out.printf("Your loot was epic! Value: %d", sum);
        } else {
            System.out.printf("Your loot was poor... Value: %d", sum);
        }

    }
}
