package class09.exercise.ComparingObjects;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Person> personList = new ArrayList<>();
        String input = sc.nextLine();
        while (!input.equals("END")) {
            String[] token = input.split("\\s+");
            personList.add(new Person(token[0], Integer.parseInt(token[1]), token[2]));
            input = sc.nextLine();
        }

        int index = Integer.parseInt(sc.nextLine());

        int equal = 0;
        int notEqual = 0;

        Person currentPerson = personList.get(index - 1);

        for (Person person : personList) {
            if (currentPerson.compareTo(person) == 0) {
                equal++;
            } else {
                notEqual++;
            }
        }

        if (equal == 1) {
            System.out.println("No matches");
        } else {
            System.out.printf("%d %d %d%n", equal, notEqual, personList.size());
        }

    }
}
