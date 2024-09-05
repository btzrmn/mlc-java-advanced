package class11.exercise.JediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimestions = InputParser.parseIntegerArray(scanner.nextLine());

        int rows = dimestions[0];
        int cols = dimestions[1];

        // create Galaxy
        Galaxy galaxy = new Galaxy(new Field(new int[rows][cols]));

        // create evil
        Evil evil = new Evil(galaxy);
        // create jedi
        Jedi jedi = new Jedi(galaxy);
        // evil destroy and jedi collect started
        Engine engine = new Engine(scanner, evil, jedi);
        engine.run();

        System.out.println(jedi.getPoints());
    }
}
