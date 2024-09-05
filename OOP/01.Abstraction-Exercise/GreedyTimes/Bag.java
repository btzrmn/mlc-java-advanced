package class11.exercise.GreedyTimes;

import java.util.*;
import java.util.stream.Collectors;

public class Bag {
    private long capacity;
    private List<Item> items;

    public Bag(long capacity) {
        this.capacity = capacity;
        this.items = new ArrayList<>();
    }

    public void add(Item item) {
        if (canBagStore(item)) {
            items.add(item);
        }
    }

    private boolean canBagStore(Item item) {
        if (capacity < getBagTotalAmount() + item.getAmount()) {
            return false;
        }
        switch (item.getItemType()) {
            case GEM:
                if (getTypeAmount(ItemType.GEM) + item.getAmount() > getTypeAmount(ItemType.GOLD)) {
                    return false;
                }
                break;
            case CASH:
                if (getTypeAmount(ItemType.CASH) + item.getAmount() > getTypeAmount(ItemType.GEM)) {
                    return false;
                }
                break;
        }
        return true;
    }

    private long getBagTotalAmount() {
        return items.stream().mapToLong(Item::getAmount).sum();
    }

    private long getTypeAmount(ItemType itemType) {
        return
                items.stream()
                        .filter(e -> e.getItemType().equals(itemType))
                        .mapToLong(Item::getAmount)
                        .sum();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Arrays.stream(ItemType.values()).forEach(e -> {
            List<Item> tempItems = items.stream().filter(p -> p.getItemType().equals(e)).collect(Collectors.toList());
            if (!tempItems.isEmpty()) {
                String itemName = e.toString().charAt(0) + e.toString().substring(1).toLowerCase();
                sb.append(String.format("<%s> $%d", itemName, getTypeAmount(e))).append(System.lineSeparator());
                getSortedValues(sb, tempItems);
            }
        });
        return sb.toString();
    }

    private void getSortedValues(StringBuilder sb, List<Item> tempItems) {
        Map<String, Long> values = new TreeMap<>();
        tempItems.stream().forEach(
                e -> {
                    String name = e.getName();
                    values.putIfAbsent(name, 0L);
                    values.put(name, values.get(name) + e.getAmount());
                });

        Map<String, Long> sortedValues = new TreeMap<>(Collections.reverseOrder());
        values.entrySet().stream()
                .sorted(Map.Entry.comparingByValue()).forEach(
                e -> {
                    sortedValues.putIfAbsent(e.getKey(), 0L);
                    sortedValues.put(e.getKey(), sortedValues.get(e.getKey()) + e.getValue());
                }
        );
        sortedValues.forEach((name, amount) -> {
            sb.append(String.format("##%s - %d", name, amount)).append(System.lineSeparator());
        });
    }
}
