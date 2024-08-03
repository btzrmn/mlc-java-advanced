package class06.exercise.google;

import java.util.LinkedHashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, Person> personData = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {

            String[] personTokens = input.split(" ");
            String name = personTokens[0];

            if (!personData.containsKey(name)) {
                personData.put(name, new Person());
            }

            switch (personTokens[1]) {
                case "children":
                    String childName = personTokens[2];
                    String childBirthday = personTokens[3];

                    Children children = new Children(childName, childBirthday);
                    personData.get(name).getChildrens().add(children);
                    break;
                case "company":
                    String companyName = personTokens[2];
                    String department = personTokens[3];
                    Double salary = Double.parseDouble(personTokens[4]);

                    Company company = new Company(companyName, department, salary);
                    personData.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = personTokens[2];
                    String pokemonType = personTokens[3];

                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    personData.get(name).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = personTokens[2];
                    String parentBirthday = personTokens[3];

                    Parents parent = new Parents(parentName, parentBirthday);
                    personData.get(name).getParents().add(parent);
                    break;
                case "car":
                    String carModel = personTokens[2];
                    int carSpeed = Integer.parseInt(personTokens[3]);

                    Car car = new Car(carModel, carSpeed);
                    personData.get(name).setCar(car);
                    break;
            }
            input = scanner.nextLine();
        }

        String wantedName = scanner.nextLine();
        System.out.println(wantedName);
        System.out.println("Company:");
        if (personData.get(wantedName).getCompany() != null) {
            System.out.printf("%s %s %.2f%n", personData.get(wantedName).getCompany().getCompanyName(),
                    personData.get(wantedName).getCompany().getDepartment(),
                    personData.get(wantedName).getCompany().getSalary());
        }
        System.out.println("Car:");
        if (personData.get(wantedName).getCar() != null) {
            System.out.printf("%s %d%n", personData.get(wantedName).getCar().getCarModel(), personData.get(wantedName).getCar().getCarSpeed());
        }
        System.out.println("Pokemon:");
        for (Pokemon pokemon : personData.get(wantedName).getPokemons()) {
            System.out.printf("%s %s%n", pokemon.getPokemonName(), pokemon.getPokemonType());
        }
        System.out.println("Parents:");
        for (Parents parent : personData.get(wantedName).getParents()) {
            System.out.printf("%s %s%n", parent.getParentName(), parent.getParentBirthday());
        }
        System.out.println("Children:");
        for (Children children : personData.get(wantedName).getChildrens()) {
            System.out.printf("%s %s%n", children.getChildName(), children.getChildBirthday());
        }
    }
}
