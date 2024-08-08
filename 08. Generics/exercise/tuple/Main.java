package class08.excercise.tuple;

import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nameAddressToken = sc.nextLine().split("\\s+");
        Tuple<String, String> firstTuple = new Tuple<>(nameAddressToken[0]+ " "+ nameAddressToken[1], nameAddressToken[2]);
        firstTuple.print();
        String[] nameBeerToken = sc.nextLine().split("\\s+");
        Tuple<String, Integer> secondTuple = new Tuple<>(nameBeerToken[0], Integer.parseInt(nameBeerToken[1]));
        secondTuple.print();
        String[] intDoubleToken = sc.nextLine().split("\\s+");
        Tuple<Integer, Double> thirdTuple = new Tuple<>(Integer.parseInt(intDoubleToken[0])
                , Double.parseDouble(intDoubleToken[1]));
        thirdTuple.print();
    }
}
