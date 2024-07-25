package class03.exercise;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class UniqueUsername {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer count  = Integer.parseInt(sc.nextLine());
        Set<String> usernames = new LinkedHashSet<>();
        for (int i = 0; i < count; i++) {
            usernames.add(sc.nextLine());
        }

        for (String username: usernames){
            System.out.println(username);
        }
    }
}
