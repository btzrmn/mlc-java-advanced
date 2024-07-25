package class03.exercise;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.TreeMap;

public class UserLogs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        TreeMap<String, LinkedHashMap<String, Integer>> logs = new TreeMap<>();

        String input = sc.nextLine();
        while (!input.equals("end")) {
            String[] token = input.split(" ");
            String name = token[2].split("=")[1];
            String ip = token[0].split("=")[1];
            if (!logs.containsKey(name)) {
                logs.put(name, new LinkedHashMap<>());
            }
            if (!logs.get(name).containsKey(ip)) {
                logs.get(name).put(ip, 1);
            } else {
                int count = logs.get(name).get(ip) + 1;
                logs.get(name).put(ip, count);
            }
            input = sc.nextLine();
        }

        for (String name : logs.keySet()) {
            System.out.println(name + ":");
            LinkedHashMap<String, Integer> ips = logs.get(name);
            LinkedHashSet<String> el = new LinkedHashSet<>();
            for (String ip : ips.keySet()) {
                el.add(ip + " => " + ips.get(ip));
            }
            System.out.println(String.join(", ", el) + ".");
        }
    }

}
