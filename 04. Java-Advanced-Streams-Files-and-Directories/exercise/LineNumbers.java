package class04.exercise;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LineNumbers {
    public static void main(String[] args) {
        String pathIn = "/Users/gan-erdene/Documents/mlc/Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputLineNumbers.txt";
        String pathOut = "/Users/gan-erdene/Documents/mlc/Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/output.txt";

        try (PrintWriter out = new PrintWriter(new FileOutputStream(pathOut))) {
            List<String> lines = Files.readAllLines(Paths.get(pathIn));
            int counter = 1;
            for (String line : lines) {
                out.println(String.format("%d. %s", counter, line));
                counter++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
