package class01.exercise;

import java.util.*;

public class BasicQueueOperations {

    public static void main(String[] args) {
        Queue<Integer> queue = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split("\\s+");

        int s = Integer.parseInt(tokens[1]);
        int x = Integer.parseInt(tokens[2]);

        String[] input = scanner.nextLine().split("\\s+");
        Arrays.stream(input).map(e -> Integer.parseInt(e))
                .forEach(e -> queue.offer(e));

        for (int j = 0; j < s; j++) {
            queue.poll();
        }

        if (queue.contains(x)) {
            System.out.println("true");
            return;
        }

        if (queue.size() > 0) {
            System.out.printf("%d", queue.stream().min(Integer::compare).get());
            return;
        }

        if (queue.size() == 0) {
            System.out.printf("0");
        }
    }
}

