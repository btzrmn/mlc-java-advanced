package class06.exercise.familyTree;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> links = new LinkedHashMap<>();
        List<Person> people = new ArrayList<>();

        String personID = sc.nextLine();

        String input = sc.nextLine();
        while (!input.equals("End")) {
            if (input.contains(" - ")) {
                String[] tokens = input.split(" - ");
                String parentId = tokens[0];
                String childId = tokens[1];
                links.putIfAbsent(parentId, new ArrayList<>());
                links.get(parentId).add(childId);
            } else {
                String[] tokens = input.split("\\s+");
                String name = tokens[0] + " " + tokens[1];
                String birthDate = tokens[2];
                people.add(new Person(name, birthDate));
            }
            input = sc.nextLine();
        }
        links.forEach((parentId, children) -> {
            Person parent = findPerson(people, parentId);

            children.stream()
                    .map(childId -> findPerson(people, childId))
                    .forEach(parent::addChild);
        });

        Person forPerson = findPerson(people, personID);

        System.out.println(getFamilyTreeFor(forPerson));
    }

    private static Person findPerson(List<Person> people, String personId) {
        return people.stream()
                .filter(person -> person.getBirthday().equals(personId) || person.getName().equals(personId))
                .findFirst()
                .orElseThrow();
    }

    public static String getFamilyTreeFor(Person person) {
        return new StringBuilder()
                .append(person.toString()).append(System.lineSeparator())
                .append("Parents:").append(System.lineSeparator())
                .append(person.getParents().stream().map(Person::toString)
                        .collect(Collectors.joining(System.lineSeparator())))
                .append(person.getParents().isEmpty() ? "" : System.lineSeparator())
                .append("Children:").append(System.lineSeparator())
                .append(person.getChildren().stream().map(Person::toString)
                        .collect(Collectors.joining(System.lineSeparator())))
                .toString();
    }

}
