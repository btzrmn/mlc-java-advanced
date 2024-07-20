package class01.exercise;

import java.util.*;

public class PoisonousPlants {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] plants = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> proximityStack = new ArrayDeque<>();
        int[] days = new int[n];
        proximityStack.push(0);
        for (int x = 1; x < n; x++) {
            int maxDays = 0;
            while (proximityStack.size() > 0 && plants[proximityStack.peek()] >= plants[x]) {

                maxDays = Integer.max(days[proximityStack.pop()], maxDays);
            }

            if (proximityStack.size() > 0) {
                days[x] = maxDays + 1;
            }

            proximityStack.push(x);
        }

        System.out.printf("%d%n", Arrays.stream(days).reduce((a, b) -> Math.max(b, a)).getAsInt());
    }

}

