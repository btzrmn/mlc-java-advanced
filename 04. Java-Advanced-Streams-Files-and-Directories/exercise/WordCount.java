package class04.exercise;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class WordCount {
    public static void main(String[] args) throws IOException {

        String wordPath = "/Users/gan-erdene/Documents/mlc/Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/words.txt";
        String textPath = "/Users/gan-erdene/Documents/mlc/Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/text.txt";
        String resultPath = "/Users/gan-erdene/Documents/mlc/Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/result.txt";

        BufferedReader wordReader = Files.newBufferedReader(Paths.get(wordPath));
        BufferedReader textReader = Files.newBufferedReader(Paths.get(textPath));

        String str = wordReader.readLine();
        String[] words = str.split(" ");
        int[] counts = new int[words.length];
        String[] textWords = textReader.readLine().split(" ");

        wordReader.close();
        textReader.close();
        // word count
        for (int i = 0; i < words.length; i++) {
            for (String text : textWords) {
                if (words[i].equals(text)) {
                    counts[i]++;
                }
            }
        }

        //sort
        for (int i = 0; i < counts.length; i++) {
            int temp = counts[i];
            for (int j = i; j < counts.length; j++) {
                if (temp < counts[j]) {
                    temp = counts[j];
                    counts[j] = counts[i];
                    counts[i] = temp;
                    String tempStr = words[i];
                    words[i] = words[j];
                    words[j] = tempStr;
                }
            }
        }

        PrintWriter out = new PrintWriter(new FileOutputStream(resultPath));
        // print
        for (int i = 0; i < counts.length; i++) {
            out.println(String.format("%s - %d", words[i], counts[i]));
            System.out.println(String.format("%s - %d", words[i], counts[i]));
        }
        out.close();
    }
}
