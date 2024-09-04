package class11.exercise.CardRank;

public class Main {
    public static void main(String[] args) {
        System.out.println("Card Ranks:");
        for (CardRank cardSuit: CardRank.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s\n",cardSuit.ordinal(), cardSuit.name());
        }
    }
}
