package class02;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();

        Map<String, Map<String, Double>> shopMap = new TreeMap<>();

        while (!command.equals("Revision")) {
            String[] lines = command.split(", ");
            String shop = lines[0];
            String product = lines[1];
            Double price = Double.parseDouble(lines[2]);
            if (shopMap.containsKey(shop)) {
                Map<String, Double> productMap = shopMap.get(shop);
                productMap.put(product, price);
                shopMap.put(shop, productMap);
            } else {
                Map<String, Double> productMap = new LinkedHashMap<>();
                productMap.put(product, price);
                shopMap.put(shop, productMap);
            }
            command = scanner.nextLine();
        }
        for (String shopKey : shopMap.keySet()) {
            System.out.printf("%s->\n", shopKey);
            for (String productKey : shopMap.get(shopKey).keySet()) {
                System.out.printf("Product: %s, Price: %.1f\n",
                        productKey, shopMap.get(shopKey).get(productKey));
            }
        }
    }
}
