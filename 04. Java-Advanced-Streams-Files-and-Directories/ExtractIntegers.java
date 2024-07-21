package class04.lab;

import java.io.*;
import java.util.Scanner;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String pathIn = "/Users/gan-erdene/Documents/mlc/Resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String pathOut = "/Users/gan-erdene/Documents/mlc/Resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams/output.txt";

        Scanner scanner = new Scanner(new FileInputStream(pathIn));
        PrintWriter out = new PrintWriter(new FileOutputStream(pathOut));

//        FileWriter writer = new FileWriter(pathOut);

        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                int num = scanner.nextInt();
//                writer.write(String.valueOf(num));
//                writer.write(System.lineSeparator());
                out.println(num);
            }
            scanner.next();
        }
        out.close();
//        writer.close();
    }
}
