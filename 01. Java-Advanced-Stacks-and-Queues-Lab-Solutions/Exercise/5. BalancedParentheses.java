package class01.exercise;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String parentheses = scanner.nextLine();

        if (isBalanced(parentheses)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    private static boolean isBalanced(String parentheses) {

        Deque<Character> openingParentheses = new ArrayDeque<>();

        for (int i = 0; i < parentheses.length(); i++) {
            char singleParentheses = parentheses.charAt(i);
            if (singleParentheses == ')') {
                if (openingParentheses.isEmpty()) {
                    return false;
                }
                char opening = openingParentheses.pop();
                if (opening != '(') {
                    return false;
                }
            } else if (singleParentheses == ']') {
                if (openingParentheses.isEmpty()) {
                    return false;
                }
                char opening = openingParentheses.pop();
                if (opening != '[') {
                    return false;
                }
            } else if (singleParentheses == '}') {
                if (openingParentheses.isEmpty()) {
                    return false;
                }
                char opening = openingParentheses.pop();
                if (opening != '{') {
                    return false;
                }
            } else {
                openingParentheses.push(singleParentheses);
            }
        }

        return true;
    }
}
