package class09.exercise.StrategyPattern;

import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Person> nameList = new TreeSet<>(new NameComparator());
        TreeSet<Person> ageList = new TreeSet<>(new AgeComparator());
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            Person person = new Person(sc.nextLine());
            nameList.add(person);
            ageList.add(person);
        }

        for (Person person : nameList) {
            person.print();
        }

        for (Person person : ageList) {
            person.print();
        }
    }
}
