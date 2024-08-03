package class06.exercise.pokemanTrainer;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Trainer> trainers = new LinkedHashMap<>();

        String input = scanner.nextLine();
        while (!input.equals("Tournament")) {
            String[] tokens = input.split(" ");
            String trainerName = tokens[0];
            String pokemonName = tokens[1];
            String pokemonElement = tokens[2];
            int pokemonHealth = Integer.parseInt(tokens[3]);
            Pokemon pokemon = new Pokemon(pokemonName, pokemonElement, pokemonHealth);
            Trainer trainer;
            if (trainers.containsKey(trainerName)) {
                trainer = trainers.get(trainerName);
            } else {
                trainer = new Trainer(trainerName);
            }
            trainer.addPokemon(pokemon);
            trainers.putIfAbsent(trainerName, trainer);

            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        while (!input.equals("End")) {
            String element = input;
            trainers.values().forEach(t -> {
                if (t.hasPokemonByElement(element)) {
                    t.addBadges();
                } else {
                    t.decreaseHealth();
                    t.removeDeadPokemon();
                }
            });
            input = scanner.nextLine();
        }

        trainers.values().stream()
                .sorted(Comparator.comparing(Trainer::getNumberOfBadges, Comparator.reverseOrder()))
                .forEach(System.out::println);

    }
}
