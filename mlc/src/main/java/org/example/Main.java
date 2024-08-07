package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] command1 = scanner.nextLine().split(": ");
        int[] coins = Arrays.stream(command1[1].split(", "))
                .mapToInt(Integer::parseInt).toArray();
        String[] command2 = scanner.nextLine().split(": ");
        int sum = Integer.parseInt(command2[1]);
        Map<Integer, Integer> map = chooseCoins(coins, sum);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.printf("%d -> %d%n", entry.getKey(), entry.getValue());
        }
    }

    public static Map<Integer, Integer> chooseCoins(int[] coins, int sum) {
        List<Integer> listCoins = Arrays.stream(coins).boxed()
                .sorted(Collections.reverseOrder()).collect(Collectors.toList());
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int currentSum = 0;
        int coinIndex = 0;
        while (currentSum != sum && coinIndex < listCoins.size()) {
            int currentCoin = listCoins.get(coinIndex);
            int remainder = sum - currentSum;
            int sizeOfCoin = remainder / currentCoin;
            if (currentSum + currentCoin <= sum) {
                map.put(currentCoin, sizeOfCoin);
                currentSum = currentSum + sizeOfCoin * currentCoin;
            }
            coinIndex++;
        }
        return map;
    }
}