package class04.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class CountCharacterTypes {
    public static void main(String[] args) {
        String path = "/Users/gan-erdene/Documents/mlc/Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

        List<Character> vowels = Arrays.asList('a', 'e', 'o', 'u', 'i');
        List<Character> symbols = Arrays.asList('!', '.', ',', '?');
        int vowelCount = 0;
        int symbolCount = 0;
        int otherCount = 0;

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            String line = reader.readLine();
            while (line != null) {
                for (char c : line.toCharArray()) {
                    if (vowels.contains(c)) {
                        vowelCount++;
                    } else if (symbols.contains(c)) {
                        symbolCount++;
                    } else if (c != 32) {
                        otherCount++;
                    }
                }
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.printf("Vowels: %d%n", vowelCount);
        System.out.printf("Other symbols: %d%n", otherCount);
        System.out.printf("Punctuation: %d%n", symbolCount);
    }
}
