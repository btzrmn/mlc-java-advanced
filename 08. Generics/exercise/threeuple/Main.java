package class08.excercise.threeuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nameAddressToken = sc.nextLine().split("\\s+");
        Threeuple<String, String,String> firstTheeuple = new Threeuple<>(nameAddressToken[0]+ " "+ nameAddressToken[1]
                , nameAddressToken[2], nameAddressToken[3]);
        firstTheeuple.print();
        String[] nameBeerToken = sc.nextLine().split("\\s+");
        Threeuple<String, Integer, Boolean> secondTheeuple = new Threeuple<>(nameBeerToken[0]
                , Integer.parseInt(nameBeerToken[1]), nameBeerToken[2].equals("drunk"));
        secondTheeuple.print();
        String[] nameAccountToken = sc.nextLine().split("\\s+");
        Threeuple<String, Double, String> thirdTheeuple = new Threeuple<>(nameAccountToken[0]
                , Double.parseDouble(nameAccountToken[1]), nameAccountToken[2]);
        thirdTheeuple.print();
    }
}
