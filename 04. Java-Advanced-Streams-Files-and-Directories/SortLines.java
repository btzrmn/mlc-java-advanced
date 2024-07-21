package class04.lab;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class SortLines {
    public static void main(String[] args) throws IOException {

        String pathIn = "/Users/gan-erdene/Documents/mlc/Resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String pathOut = "/Users/gan-erdene/Documents/mlc/Resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams/output.txt";

        try (InputStream in = new FileInputStream(pathIn);
             PrintWriter out =
                     new PrintWriter(new FileWriter(pathOut))) {
            Path path = Paths.get(pathIn);

            List<String> lines = Files.readAllLines(path);
            Collections.sort(lines);
            lines.forEach(out::println);

            System.out.println();
        }
    }
}
