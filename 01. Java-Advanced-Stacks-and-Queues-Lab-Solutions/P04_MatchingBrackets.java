import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P04_MatchingBrackets {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();
        Deque<Integer> stack = new ArrayDeque<>();
        for (int index = 0; index < expression.length(); index++) {
            char ch = expression.charAt(index);
            if (ch == '(') {
                stack.push(index);
            }
            else if (ch == ')') {
                int startIndex = stack.pop();
                String contents = expression.substring(startIndex, index + 1);
                System.out.println(contents);
            }
        }
    }
}
