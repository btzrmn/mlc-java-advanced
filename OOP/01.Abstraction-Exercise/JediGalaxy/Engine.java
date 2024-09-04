package class11.exercise.JediGalaxy;

import java.util.Scanner;

public class Engine {
    private Scanner scanner;
    private Evil evil;
    private Jedi jedi;

    public Engine(Scanner scanner, Evil evil, Jedi jedi) {
        this.scanner = scanner;
        this.evil = evil;
        this.jedi = jedi;
    }

    public void run() {
        String command = scanner.nextLine();

        while (!command.equals("Let the Force be with you")) {

            int[] jediPosition = InputParser.parseIntegerArray(command);
            int[] evilPosition = InputParser.parseIntegerArray(scanner.nextLine());

            evil.destroyStars(evilPosition[0], evilPosition[1]);
            jedi.collectStars(jediPosition[0], jediPosition[1]);
            command = scanner.nextLine();
        }
    }
}
