import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P03_DecimalToBinary {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int decimal = Integer.valueOf(scanner.nextLine());

        Deque<Integer> stack = new ArrayDeque<>();

        if (decimal == 0) {
            stack.push(0);
        }

        while (decimal != 0) {
            stack.push(decimal % 2);
            decimal /= 2;
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
