package class04.exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class SumLines {
    public static void main(String[] args) {

        // oroltiin utga bairlaj bui zam
        String path = "/Users/gan-erdene/Documents/mlc/Resources/04. Java-Advanced-Files-and-Streams-Exercises-Resources/input.txt";

        // tuhain zamaas file aa unshih unshigch beldej bn
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
            // ehnii neg mur utgiig huleen avch bn
            String line = reader.readLine();
            // buh mor utgiig unshih while bichsen bn
            while (line != null) {
                // tuhain muriin ASCII niilberiig hadgalah huvisagch zarlaj bn
                long sum = 0;

                // Tuhain muriin utgiig temdegt turliin arrayluu hurvuulj neg bureer niilber hadgalah utga luu nemj bn
                for (char c : line.toCharArray()) {
                    sum += c;
                }
                // nillberee hevlej bn aa
                System.out.println(sum);
                // shine muriin utgeer line iig duurgej bn
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
