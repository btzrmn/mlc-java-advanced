package class04.lab;

import java.io.*;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String pathIn = "/Users/gan-erdene/Documents/mlc/Resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/input.txt";
        String pathOut = "/Users/gan-erdene/Documents/mlc/Resources/04. Java-Advanced-Files-and-Streams-Lab-Resources/Files-and-Streams/output.txt";

        try (InputStream in = new FileInputStream(pathIn);
             OutputStream out = new FileOutputStream(pathOut)) {
            int oneByte = 0;
            while ((oneByte = in.read()) >= 0) {
                if (oneByte == 10 || oneByte == 32) {
                    out.write(oneByte);
                } else {
                    String digits = String.valueOf(oneByte);
                    for (int i = 0; i < digits.length(); i++)
                        out.write(digits.charAt(i));
                }
            }
        }

    }
}
