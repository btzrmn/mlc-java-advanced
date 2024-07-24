package class03.exercise;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        LinkedHashMap<String, HashSet<String>> playerCards = new LinkedHashMap<>();

        String input = sc.nextLine();
        while (!input.equals("JOKER")) {
            String[] token = input.split(":");
            String name = token[0].trim();
            String[] cards = token[1].trim().split(", ");
            if (!playerCards.containsKey(name)) {
                playerCards.put(name, new HashSet<>());
            }
            for (String card : cards) {
                playerCards.get(name).add(card);
            }
            input = sc.nextLine();
        }

        for (String name : playerCards.keySet()) {
            System.out.println(name + ": " + calculateCard(playerCards.get(name)));
        }

    }

    public static int calculateCard(HashSet<String> cards) {
        int score = 0;
        for (String card : cards) {
            String p = card.substring(0, card.length() - 1);
            Character t = card.charAt(card.length() - 1);
            score += getPPoint(p) * getTPoint(t);
        }
        return score;
    }

    public static int getTPoint(Character ch) {
        int point;
        switch (ch) {
            case 'S':
                point = 4;
                break;
            case 'H':
                point = 3;
                break;
            case 'D':
                point = 2;
                break;
            case 'C':
                point = 1;
                break;
            default:
                point = 0;
                break;
        }
        return point;
    }

    public static int getPPoint(String ch) {
        int point;
        switch (ch) {
            case "2":
                point = 2;
                break;
            case "3":
                point = 3;
                break;
            case "4":
                point = 4;
                break;
            case "5":
                point = 5;
                break;
            case "6":
                point = 6;
                break;
            case "7":
                point = 7;
                break;
            case "8":
                point = 8;
                break;
            case "9":
                point = 9;
                break;
            case "10":
                point = 10;
                break;
            case "J":
                point = 11;
                break;
            case "Q":
                point = 12;
                break;
            case "K":
                point = 13;
                break;
            case "A":
                point = 14;
                break;
            default:
                point = 0;
                break;
        }
        return point;
    }
}
