package class06.exercise.catLady;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, Cat> cats = new HashMap<>();

        String line = scanner.nextLine();
        while (!line.equals("End")) {

            String[] tokens = line.split("\\s+");
            String catType = tokens[0];
            String catName = tokens[1];
            double additionalParameter = Double.parseDouble(tokens[2]);

            Cat cat = null;
            switch (catType) {
                case "Siamese":
                    cat = new Siamese(catType, catName, additionalParameter);
                    break;
                case "Cymric":
                    cat = new Cymric(catType, catName, additionalParameter);
                    break;
                case "StreetExtraordinaire":
                    cat = new StreetExtraordinaire(catType, catName, additionalParameter);
                    break;
            }

            cats.put(catName, cat);
            line = scanner.nextLine();
        }

        System.out.println(cats.get(scanner.nextLine()));
    }
}
