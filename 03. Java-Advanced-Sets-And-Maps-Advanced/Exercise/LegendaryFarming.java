package class03.exercise;

import java.util.*;

public class LegendaryFarming {
    public static List<String> legendaryItems = Arrays.asList("fragments", "shards", "motes");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeMap<String, Integer> legendaryMap = new TreeMap<>();
        legendaryMap.put("fragments", 0);
        legendaryMap.put("shards", 0);
        legendaryMap.put("motes", 0);
        TreeMap<String, Integer> junkMap = new TreeMap<>();
        boolean obtain = false;

        while (!obtain) {
            String[] token = sc.nextLine().split("\\s+");
            for (int i = 0; i < token.length; i += 2) {
                int quantity = Integer.parseInt(token[i]);
                String material = token[i + 1].toLowerCase();
                if (legendaryItems.contains(material)) {
                    int total = legendaryMap.get(material) + quantity;
                    legendaryMap.put(material, total);
                } else {
                    if (!junkMap.containsKey(material)) {
                        junkMap.put(material, quantity);
                    } else {
                        int total = junkMap.get(material) + quantity;
                        junkMap.put(material, total);
                    }
                }

                if (legendaryMap.get("fragments") >= 250) {
                    System.out.println("Valanyr obtained!");
                    int total = legendaryMap.get(material) - 250;
                    legendaryMap.put(material, total);
                    obtain = true;
                    break;
                }
                if (legendaryMap.get("shards") >= 250) {
                    System.out.println("Shadowmourne obtained!");
                    int total = legendaryMap.get(material) - 250;
                    legendaryMap.put(material, total);
                    obtain = true;
                    break;
                }
                if (legendaryMap.get("motes") >= 250) {
                    System.out.println("Dragonwrath obtained!");
                    int total = legendaryMap.get(material) - 250;
                    legendaryMap.put(material, total);
                    obtain = true;
                    break;
                }
            }

        }

        legendaryMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue((v1, v2) -> v2.compareTo(v1)))
                .forEach(m ->
                        System.out.println(m.getKey() + ": " + m.getValue())
                );

        junkMap.entrySet().stream().forEach(m ->
                System.out.println(m.getKey() + ": " + m.getValue()));
    }


}
