
package class11.exercise.GreedyTimes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacity = Long.parseLong(scanner.nextLine());
        String[] safe = scanner.nextLine().split("\\s+");
        Bag bag = new Bag(capacity);
        Item item;

        for (int i = 0; i < safe.length; i += 2) {
            String name = safe[i];
            long amount = Long.parseLong(safe[i + 1]);
            try {
                item = createItem(name, amount);
            } catch (IllegalArgumentException e){
                continue;
            }
            bag.add(item);
        }

        System.out.print(bag);
    }

    private static Item createItem(String name, long amount) {
        ItemType itemType;
        if(name.length() == 3){
            itemType = ItemType.CASH;
        } else if(name.length()>=4 && name.toLowerCase().endsWith("gem")){
            itemType = ItemType.GEM;
        } else if(name.equalsIgnoreCase("gold")){
            itemType = ItemType.GOLD;
        } else {
            throw new IllegalArgumentException("Not valid type");
        }

        return new Item(itemType, name, amount);
    }
}