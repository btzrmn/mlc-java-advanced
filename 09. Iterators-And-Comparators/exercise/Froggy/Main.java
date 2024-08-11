package class09.exercise.Froggy;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Lake lake = new Lake(sc.nextLine());
        String input = sc.nextLine();
        if(input.equals("END"))
            lake.jump();
    }
}
