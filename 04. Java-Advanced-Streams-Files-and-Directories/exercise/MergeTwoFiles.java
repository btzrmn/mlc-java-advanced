package class04.exercise;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String input1 = "/Users/gan-erdene/Documents/mlc/Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputOne.txt";
        String input2 = "/Users/gan-erdene/Documents/mlc/Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/inputTwo.txt";
        String resultPath = "/Users/gan-erdene/Documents/mlc/Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/result.txt";
        List<String> lines1 = Files.readAllLines(Paths.get(input1));
        List<String> lines2 = Files.readAllLines(Paths.get(input2));
        lines1.addAll(lines2);
        PrintWriter writer = new  PrintWriter(new FileOutputStream(resultPath));
        lines1.forEach(line -> writer.println(line));
        writer.close();
    }
}
