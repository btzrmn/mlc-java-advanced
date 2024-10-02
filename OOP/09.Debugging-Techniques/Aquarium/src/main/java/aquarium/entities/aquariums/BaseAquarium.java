package aquarium.entities.aquariums;

import aquarium.common.ExceptionMessages;
import aquarium.entities.decorations.Decoration;
import aquarium.entities.fish.Fish;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public abstract class BaseAquarium implements Aquarium {
    private String name;
    private int capacity;
    private Collection<Decoration> decorations;
    private Collection<Fish> fish;

    public BaseAquarium(String name, int capacity) {
        this.setName(name);
        this.capacity = capacity;
        this.decorations = new ArrayList<>();
        this.fish = new ArrayList<>();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(ExceptionMessages.AQUARIUM_NAME_NULL_OR_EMPTY);
        }
        this.name = name;
    }

    public int calculateComfort() {
        return this.decorations.stream().mapToInt(Decoration::getComfort).sum();
    }

    public String getName() {
        return this.name;
    }

    public void addFish(Fish fish) {
        this.fish.add(fish);
    }

    public void removeFish(Fish fish) {
        this.fish.remove(fish);
    }

    public void addDecoration(Decoration decoration) {
        this.decorations.add(decoration);
    }

    public void feed() {
        this.fish.forEach(Fish::eat);
    }

    public String getInfo() {
        StringBuilder str = new StringBuilder();
        str.append(String.format("%s (%d)", this.name, this.capacity))
                .append(System.lineSeparator())
                .append("Fish: ");
        str.append(this.fish.isEmpty() ? "none" : this.fish.stream().map(Fish::getName).collect(Collectors.joining(" ")))
                .append(System.lineSeparator());
        str.append("Decorations: ").append(this.decorations.size()).append(System.lineSeparator());
        str.append("Comfort: ").append(this.calculateComfort());
        return str.toString();
    }

    public Collection<Fish> getFish() {
        return Collections.unmodifiableCollection(this.fish);
    }

    public Collection<Decoration> getDecorations() {
        return Collections.unmodifiableCollection(this.decorations);
    }

}
