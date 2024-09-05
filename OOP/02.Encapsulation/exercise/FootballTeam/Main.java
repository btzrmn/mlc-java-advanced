package oop01.exercise.FootballTeam;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Team> teams = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split(";");
            String command = tokens[0];
            String teamName = tokens[1];

            try {
                String playerName = null;
                Team team = null;
                switch (command) {
                    case "Team":
                        teams.putIfAbsent(teamName, new Team(teamName));
                        break;
                    case "Add":
                        team = teams.get(teamName);
                        if (team == null) {
                            throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
                        }
                        playerName = tokens[2];
                        int endurance = Integer.parseInt(tokens[3]);
                        int sprint = Integer.parseInt(tokens[4]);
                        int dribble = Integer.parseInt(tokens[5]);
                        int passing = Integer.parseInt(tokens[6]);
                        int shooting = Integer.parseInt(tokens[7]);
                        Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                        team.addPlayer(player);
                        break;
                    case "Remove":
                        playerName = tokens[2];
                        teams.get(teamName).removePlayer(playerName);
                        break;
                    case "Rating":
                        team = teams.get(teamName);
                        if (team == null) {
                            throw new IllegalArgumentException(String.format("Team %s does not exist.", teamName));
                        }
                        System.out.printf("%s – %.0f", teamName, team.getRating());
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            input = scanner.nextLine();
        }
    }
}
