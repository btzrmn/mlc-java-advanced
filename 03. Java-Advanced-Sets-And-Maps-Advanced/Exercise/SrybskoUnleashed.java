package class03.exercise;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class SrybskoUnleashed {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, LinkedHashMap<String, Integer>> concertMap = new LinkedHashMap<>();
        String input = sc.nextLine();
        while (!input.equals("End")) {
            String[] token = input.split("@");
            if (token[0].charAt(token[0].length() - 1) != ' ') {
                input = sc.nextLine();
                continue;
            }
            String singer = token[0];

            String[] others = token[1].split(" ");
            int price;
            int count;
            try {
                price = Integer.parseInt(others[others.length - 2]);
                count = Integer.parseInt(others[others.length - 1]);
            } catch (Exception e) {
                input = sc.nextLine();
                continue;
            }
            StringBuilder venueBuilder = new StringBuilder();
            for (int i = 0; i < others.length - 2; i++) {
                venueBuilder.append(others[i]);
                venueBuilder.append(" ");
            }

            String venue = venueBuilder.toString().trim();

            if (!concertMap.containsKey(venue)) {
                concertMap.put(venue, new LinkedHashMap<>());
            }

            if (!concertMap.get(venue).containsKey(singer)) {
                concertMap.get(venue).put(singer, price * count);
            } else {
                int total = concertMap.get(venue).get(singer) + price * count;
                concertMap.get(venue).put(singer, total);
            }

            input = sc.nextLine();
        }

        for (String venue: concertMap.keySet()){
            System.out.println(venue);
            LinkedHashMap<String, Integer> singers = concertMap.get(venue);
            singers.entrySet().stream().sorted(Map.Entry.comparingByValue((k1,k2)-> k2.compareTo(k1))).forEach(e ->
                    System.out.printf("#  %s-> %d%n", e.getKey(), e.getValue())
            );
        }
    }
}
