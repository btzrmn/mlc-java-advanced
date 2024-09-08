package oop01.exercise.FootballTeam;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name == null || name.trim().length() < 1) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String playerName) {
        boolean isRemoved = this.players.removeIf(p -> p.getName().equals(playerName));
        if (!isRemoved) {
            String message = String.format("Player %s is not in %s team.", playerName, this.name);
            throw new IllegalArgumentException(message);
        }
    }

    public double getRating() {
        double rating = this.players.stream()
                .mapToDouble(Player::overallSkillLevel)
                .average()
                .orElse(0);
        return rating;
    }
}
