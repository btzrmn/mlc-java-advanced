package class11.exercise.CardWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CardRank cardRank = Enum.valueOf(CardRank.class, sc.nextLine());
        CardSuit cardSuit = Enum.valueOf(CardSuit.class, sc.nextLine());

        System.out.printf("Card name: %s of %s; Card power: %d"
                , cardRank, cardSuit, cardRank.getPower() + cardSuit.getPower());
    }
}
