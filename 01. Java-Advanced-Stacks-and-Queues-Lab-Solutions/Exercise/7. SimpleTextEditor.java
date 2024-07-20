package class01.exercise;

import java.util.*;

public class SimpleTextEditor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<Character> text = new ArrayList<>();
        ArrayDeque<String> commands = new ArrayDeque<>();
        ArrayDeque<String> removedElements = new ArrayDeque<>();


        for (int i = 0; i < n; i++) {
            String rawCommand = scanner.nextLine();
            String[] commandArgs = rawCommand.split("\\s+");
            String commandType = commandArgs[0];
            switch (commandType) {
                case "1":
                    commands.push(rawCommand);
                    executeAddCommand(commandArgs[1], text);
                    break;
                case "2":
                    commands.push(rawCommand);
                    int countToDelete = Integer.parseInt(commandArgs[1]);
                    saveElementsToDelete(text, countToDelete, removedElements);
                    executeEraseCommand(countToDelete, text);
                    break;
                case "3":
                    int indexOfElement = Integer.parseInt(commandArgs[1]);
                    System.out.printf("%s%n", text.get(indexOfElement - 1));
                    break;
                case "4":
                    String lastCommand = commands.pop();
                    String[] lastCommandArgs = lastCommand.split("\\s+");
                    String lastCommandType = lastCommandArgs[0];
                    if (lastCommandType.equals("1")) {
                        int numberOfElementsToDelete = lastCommandArgs[1].length();
                        executeEraseCommand(numberOfElementsToDelete, text);
                    } else {
                        String elementsToReAdd = removedElements.pop();
                        executeAddCommand(elementsToReAdd, text);
                    }
                    break;
            }
        }
    }

    private static void saveElementsToDelete(
            List<Character> text,
            int countToDelete,
            ArrayDeque<String> removedElements) {
        StringBuilder sb = new StringBuilder();
        for (int i = text.size() - countToDelete; i < text.size(); i++) {
            sb.append(text.get(i));
        }
        removedElements.push(sb.toString());
    }

    private static void executeAddCommand(String elementsToAdd, List<Character> text) {
        for (int i = 0; i < elementsToAdd.length(); i++) {
            text.add(elementsToAdd.charAt(i));
        }
    }

    private static void executeEraseCommand(int countToDelete, List<Character> text) {
        int textLength = text.size();
        for (int j = 1; j <= countToDelete; j++) {
            text.remove(textLength - j);
        }
    }

}

