package class03.exercise;

import java.util.*;

public class FixEmails {
    public static List<String> domains = Arrays.asList("us", "uk", "com");

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, String> emails = new LinkedHashMap<>();
        while (true) {
            String name = sc.nextLine();
            if (name.equals("stop")) {
                break;
            }
            String email = sc.nextLine();
            String[] token = email.split("\\.");
            if (!domains.contains(token[token.length - 1])) {
                emails.put(name, email);
            }
        }

        for (String name : emails.keySet()) {
            System.out.println(name + " -> " + emails.get(name));
        }
    }
}
