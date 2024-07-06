package class02;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] line = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble).toArray();
        Map<Double, Integer> map = new LinkedHashMap<>();
        for (double d : line) {
            if (!map.containsKey(d)) {
                map.put(d, 1);
            } else {
                map.put(d, map.get(d) + 1);
            }
        }
        for (Double key : map.keySet()) {
            System.out.printf("%.1f -> %d\n", key, map.get(key));
        }
    }
}
