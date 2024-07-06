package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSet<String> hashSet = new LinkedHashSet<>();
        String line = scanner.nextLine();
        while (!line.equals("END")) {
            String[] split = line.split(", ");
            if (split[0].equals("IN")) {
                hashSet.add(split[1]);
            } else {
                hashSet.remove(split[1]);
            }
            line = scanner.nextLine();
        }
        if (hashSet.isEmpty()) {
            System.out.println("Parking Lot is Empty");
        } else {
            for (String value : hashSet) {
                System.out.println(value);
            }
        }
    }
}