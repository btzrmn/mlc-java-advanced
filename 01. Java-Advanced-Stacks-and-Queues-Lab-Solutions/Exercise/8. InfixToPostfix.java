package class01.exercise;

import java.util.*;

public class InfixToPostfix {

    private final static Set<String> operators = new HashSet<>();

    public static void main(String[] args) {
        Collections.addAll(operators, "+", "-", "*", "/");

        Scanner scanner = new Scanner(System.in);
        String infix = scanner.nextLine();
        String[] tokens = infix.split("\\s+");

        ArrayDeque<String> operatorStack = new ArrayDeque<>();
        ArrayDeque<String> outputQueue = new ArrayDeque<>();

        ArrayDeque<String> postfix = getPostfix(tokens, operatorStack, outputQueue);

        while (!postfix.isEmpty()) {
            System.out.print(postfix.poll() + " ");
        }
    }

    private static ArrayDeque<String> getPostfix(String[] tokens, ArrayDeque<String> operatorStack, ArrayDeque<String> outputQueue) {

        for (String token : tokens) {
            if (isNumber(token)) {
                outputQueue.offer(token);
            }
            else if (operators.contains(token)) {
                int precedence = getPrecedence(token);
                while (!operatorStack.isEmpty() && getPrecedence(operatorStack.peek()) >= precedence) {
                    outputQueue.offer(operatorStack.pop());
                }

                operatorStack.push(token);
            }
            else if (token.equals("(")) {
                operatorStack.push(token);
            }
            else if (token.equals(")")) {
                while (!operatorStack.isEmpty() && !operatorStack.peek().equals("(")) {
                    outputQueue.offer(operatorStack.pop());
                }

                operatorStack.pop();
            }
        }

        while (!operatorStack.isEmpty()) {
            outputQueue.offer(operatorStack.pop());
        }

        return outputQueue;
    }

    private static int getPrecedence(String token) {
        switch (token) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            case "(":
            case ")":
                return -1;
            default:
                return 1;
        }
    }

    private static boolean isNumber(String token) {
        return !operators.contains(token) && !(token.equals("(") || token.equals(")"));
    }
}
