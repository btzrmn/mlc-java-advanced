package class11.exercise.GreedyTimes;

public class Item {
    private ItemType itemType;
    private String name;
    private long amount;

    public Item(ItemType itemType, String name, long amount) {
        this.itemType = itemType;
        this.name = name;
        this.amount = amount;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public String getName() {
        return name;
    }

    public long getAmount() {
        return amount;
    }
}
