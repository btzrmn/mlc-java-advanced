package football.entities.field;

import football.entities.player.Player;
import football.entities.supplement.Supplement;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BaseField implements Field {
    private String name;
    private int capacity;
    private Collection<Supplement> supplements;
    private Collection<Player> players;

    public BaseField(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.supplements = new ArrayList<>();
        this.players = new ArrayList<>();
    }

    @Override
    public int sumEnergy() {
        return this.supplements.stream().mapToInt(s -> s.getEnergy()).sum();
    }

    @Override
    public void addPlayer(Player player) {
        if (this.capacity < this.players.size()) {
            throw new IllegalStateException("Not enough capacity.");
        }
        this.players.add(player);
    }

    @Override
    public void removePlayer(Player player) {
        this.players.remove(player);
    }

    @Override
    public void addSupplement(Supplement supplement) {
        this.supplements.add(supplement);
    }

    @Override
    public void drag() {
        for (Player player : this.players) {
            player.stimulation();
        }
    }

    @Override
    public String getInfo() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s (%s):\n", this.getName(), this.getClass().getSimpleName()));
        sb.append("Player: ");
        for (Player player : this.players) {
            sb.append(player.getName()).append(" ");
        }
        sb.append("\n");
        sb.append(String.format("Supplement: %d\n", this.supplements.size()));
        sb.append(String.format("Energy: %d", this.sumEnergy()));
        return sb.toString();
    }

    @Override
    public Collection<Player> getPlayers() {
        return this.players;
    }

    @Override
    public Collection<Supplement> getSupplements() {
        return this.supplements;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
