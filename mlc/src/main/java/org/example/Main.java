package org.example;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Main {
    private final static Set<String> operators = new HashSet<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] lineArgs = scanner.nextLine().split(";");

        String[] robots = new String[lineArgs.length];
        int[] processTimes = new int[lineArgs.length];
        int[] robotCounters = new int[lineArgs.length];

        for (int i = 0; i < lineArgs.length; i++) {
            String[] robotArgs = lineArgs[i].split("-");
            robots[i] = robotArgs[0];
            processTimes[i] = Integer.valueOf(robotArgs[1]);
            robotCounters[i] = 0;
        }

        String[] timeArgs = scanner.nextLine().split(":");
        long hh = Integer.valueOf(timeArgs[0]) * 60 * 60;
        long mm = Integer.valueOf(timeArgs[1]) * 60;
        long ss = Integer.valueOf(timeArgs[2]);
        long time = hh + mm + ss;

        Deque<String> products = new ArrayDeque<>();

        String product = "";
        while (!(product = scanner.nextLine()).equals("End")) {
            products.offer(product);
        }

        while (!products.isEmpty()) {
            for (int i = 0; i < robots.length; i++) {
                if (robotCounters[i] > 0) {
                    robotCounters[i]--;
                }
            }

            time++;

            String currentProduct = products.poll();
            boolean isProductTaken = false;

            for (int i = 0; i < robots.length; i++) {
                if (robotCounters[i] == 0) {
                    robotCounters[i] = processTimes[i];
                    System.out.printf("%s - %s [%s]%n", robots[i], currentProduct, getTime(time));
                    isProductTaken = true;
                    break;
                }
            }

            if (!isProductTaken) {
                products.offer(currentProduct);
            }
        }
    }

    private static String getTime(long time) {
        String hours = String.format("%2s", (time / 60 / 60) % 24).replace(' ', '0');
        String minutes = String.format("%2s", (time / 60) % 60).replace(' ', '0');
        String seconds = String.format("%2s", time % 60).replace(' ', '0');

        return String.format("%s:%s:%s", hours, minutes, seconds);
    }
}