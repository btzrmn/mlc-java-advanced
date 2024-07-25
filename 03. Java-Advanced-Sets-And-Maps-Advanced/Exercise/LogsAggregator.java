package class03.exercise;

import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, TreeSet<String>> ipAddresses = new TreeMap<String, TreeSet<String>>();
        TreeMap<String, Integer> userDuration = new TreeMap<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] token = sc.nextLine().split(" ");
            String ip = token[0];
            String user = token[1];
            Integer duration = Integer.parseInt(token[2]);
            if (!ipAddresses.containsKey(user)) {
                ipAddresses.put(user, new TreeSet<>());
                userDuration.put(user, 0);
            }

            ipAddresses.get(user).add(ip);

            int tempDuration = userDuration.get(user) + duration;
            userDuration.put(user, tempDuration);
        }

        for (String user : userDuration.keySet()) {
            System.out.printf("%s: %d ", user, userDuration.get(user));
            System.out.print(ipAddresses.get(user));
            System.out.println();
        }
    }
}
