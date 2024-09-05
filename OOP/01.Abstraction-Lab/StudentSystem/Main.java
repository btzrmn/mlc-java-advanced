package class11.lab.StudentSystem;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();
        while (true)
        {
            String[] input = scanner.nextLine().split(" ");
            if (input[0].equals("Exit")){
                break;
            } else if (input[0].equals("Create")) {
                studentSystem.create(input);
            } else if (input[0].equals("Show")) {
                studentSystem.show(input[1]);
            }
        }
    }
}


