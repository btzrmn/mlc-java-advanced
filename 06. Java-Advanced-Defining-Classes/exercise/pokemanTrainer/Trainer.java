package class06.exercise.pokemanTrainer;

import java.util.ArrayList;
import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> pokemons;

    public int getNumberOfBadges() {
        return numberOfBadges;
    }

    public Trainer(String name) {
        this.name = name;
        this.numberOfBadges = 0;
        this.pokemons = new ArrayList<>();
    }

    public void addPokemon(Pokemon pokemon) {
        pokemons.add(pokemon);
    }

    public boolean hasPokemonByElement(String element) {
        return this.pokemons.stream().anyMatch(p -> p.getElement().equals(element));
    }

    public void addBadges() {
        this.numberOfBadges++;
    }

    public void decreaseHealth() {
        this.pokemons.forEach(Pokemon::decreaseHealth);
    }

    public void removeDeadPokemon() {
        this.pokemons.removeIf(p -> p.getHealth() <= 0);
    }

    @Override
    public String toString() {
        return String.format("%s %d %d", this.name, this.numberOfBadges, this.pokemons.size());
    }
}
