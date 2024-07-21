package class04.lab;

import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {

        String pathIn = "/Users/gan-erdene/Documents/mlc/Resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String pathOut = "/Users/gan-erdene/Documents/mlc/Resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams/output.txt";

        try (BufferedReader in = new BufferedReader(new FileReader(pathIn));
             PrintWriter out = new PrintWriter(new FileWriter(pathOut))) {
            int counter = 1;
            String line = in.readLine();
            while (line != null) {
                if (counter % 3 == 0)
                    out.println(line);
                counter++;
                line = in.readLine();
            }
        }


    }
}
