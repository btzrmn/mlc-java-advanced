package SoftUni.Advanced.C01StackQueues;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class E07MathPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<String> priorityQueue = new PriorityQueue<>();

        String[] names = scanner.nextLine().split("\\s+");
        Collections.addAll(priorityQueue, names);

        int numOfRotations = Integer.parseInt(scanner.nextLine());

        int startCycle = 1;
        while (priorityQueue.size() > 1) {

            for (int i = 1; i < numOfRotations; i++) {
                priorityQueue.offer(priorityQueue.poll());
            }

            if (comp(startCycle)) {
                System.out.println("Prime " + priorityQueue.peek());
            } else {
                System.out.println("Removed " + priorityQueue.poll());
            }
            startCycle++;
        }
        System.out.println("Last is " + priorityQueue.poll());
    }

    public static boolean comp(int startCycle) {
        int count = 0;
        for (int i = 2; i <= startCycle; i++) {
            if (startCycle % i == 0) {
                count++;
            }
        }
        return count == 1;
    }
}
