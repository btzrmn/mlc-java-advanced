package class02;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> vip = new HashSet<>();
        HashSet<String> regular = new HashSet<>();
        String line = scanner.nextLine();
        while (!line.equals("PARTY")) {
            if (Character.isDigit(line.charAt(0))) {
                vip.add(line);
            } else {
                regular.add(line);
            }
            line = scanner.nextLine();
        }
        while (!line.equals("END")) {
            if (Character.isDigit(line.charAt(0))) {
                vip.remove(line);
            } else {
                regular.remove(line);
            }
            line = scanner.nextLine();
        }
        if (vip.size() + regular.size() > 0)
            System.out.println(vip.size() + regular.size());
        for (String v : vip) {
            System.out.println(v);
        }
        for (String r : regular) {
            System.out.println(r);
        }
    }
}
