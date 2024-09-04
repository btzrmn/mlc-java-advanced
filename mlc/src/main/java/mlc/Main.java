package mlc;

import java.nio.charset.StandardCharsets;
import java.util.zip.Checksum;

public class Main {
    public static void main(String[] args) {
        String a = "$HX,0005,860721009307562,S,010119,031510,A/063703/4755.255737/N/10654.708710/E/0.00/50.98/040924,,,,,#,1c,";
        String[] values = a.split(",");
        StringBuilder test = new StringBuilder();
        for (int i = 3; i < values.length; i++) {
            if (!values[i].isEmpty())
                test.append(values[i]).append(",");
        }
        String[] list = test.toString().split(",#");
        if (list.length > 1) {
            String ttt = list[0];
            String sentence = String.format("$HX,%s,%s,%s,#", "1001", "860721009307562", ttt);
            sentence += String.format(",%02x,\r\n", xor(sentence));
            System.out.println(sentence + ",OK");
        }
    }

    public static int xor(String string) {
        byte checksum = 0;
        for (byte b : string.getBytes(StandardCharsets.US_ASCII)) {
            checksum ^= b;
        }
        return checksum;
    }
}
