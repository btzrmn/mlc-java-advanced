package class02;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Map<Integer, String> products = new HashMap<>();
        products.entrySet().stream().sorted((e1, e2) -> {
            int res = e2.getValue().compareTo(e1.getValue());
            if (res == 0)
                res = e1.getKey().compareTo(e2.getKey());
            return res;
        })
        for (String e : products.entrySet()) {

        });
    }

    public static test(String e1, String e2) {
        e1.compareTo(2);
        if (1 > 2) {
            return false;
            e1.compareTo(2);
        }
    }
}
