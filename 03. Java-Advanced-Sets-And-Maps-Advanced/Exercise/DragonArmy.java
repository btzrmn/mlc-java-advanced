package class03.exercise;

import java.util.LinkedHashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class DragonArmy {
    public static int defaultDamage = 45;
    public static int defaultHealth = 250;
    public static int defaultArmor = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LinkedHashMap<String, TreeMap<String, int[]>> dragons = new LinkedHashMap<>();
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String[] token = sc.nextLine().split("\\s+");
            String type = token[0];
            String name = token[1];
            int damage = token[2].equals("null") ? defaultDamage : Integer.parseInt(token[2]);
            int health = token[3].equals("null") ? defaultHealth : Integer.parseInt(token[3]);
            int armor = token[4].equals("null") ? defaultArmor : Integer.parseInt(token[4]);
            if (!dragons.containsKey(type)) {
                dragons.put(type, new TreeMap<>());
            }
            if (!dragons.get(type).containsKey(name)) {
                dragons.get(type).put(name, new int[3]);
            }
            dragons.get(type).get(name)[0] = damage;
            dragons.get(type).get(name)[1] = health;
            dragons.get(type).get(name)[2] = armor;
        }

        for (String type : dragons.keySet()) {
            double[] avg = calcAvarage(dragons.get(type));
            System.out.printf("%s::(%.2f/%.2f/%.2f)%n", type, avg[0], avg[1], avg[2]);
            TreeMap<String, int[]> typeDragons = dragons.get(type);
            typeDragons.entrySet().stream()
                    .forEach(e ->
                            System.out.printf("-%s -> damage: %d, health: %d, armor: %d%n", e.getKey(), e.getValue()[0], e.getValue()[1], e.getValue()[2])
                    );
        }
    }

    private static double[] calcAvarage(TreeMap<String, int[]> dragons) {
        int totalDamage = 0;
        int totalHealth = 0;
        int totalArmor = 0;
        for (String name : dragons.keySet()) {
            totalDamage += dragons.get(name)[0];
            totalHealth += dragons.get(name)[1];
            totalArmor += dragons.get(name)[2];
        }
        return new double[]{(double) totalDamage / dragons.size(), (double) totalHealth / dragons.size(), (double) totalArmor / dragons.size()};
    }
}
