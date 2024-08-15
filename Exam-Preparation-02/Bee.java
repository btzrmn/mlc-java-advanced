package examPreparation2;

import java.util.Scanner;

public class Bee {

    static int beeRow;
    static int beeCol;
    static boolean isOut = false;
    static int pollinateCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            matrix[i] = line.toCharArray();
            if (line.contains("B")) {
                beeRow = i;
                beeCol = line.indexOf("B");
            }
        }
        String command = scanner.nextLine();
        while (!command.equals("End")) {
            switch (command) {
                case "up":
                    moveUp(matrix);
                    break;
                case "down":
                    moveDown(matrix);
                    break;
                case "left":
                    moveLeft(matrix);
                    break;
                case "right":
                    moveRight(matrix);
                    break;
            }
//            System.out.println();
//            print(matrix);
            if (isOut) {
                System.out.println("The bee got lost!");
                break;
            }
            command = scanner.nextLine();
        }

        if (pollinateCount >= 5) {
            System.out.printf("Great job, the bee manage to pollinate %d flowers!%n", pollinateCount);
        } else {
            System.out.printf("The bee couldn't pollinate the flowers, she needed %d flowers more%n", 5 - pollinateCount);
        }
        print(matrix);
    }

    private static void moveUp(char[][] matrix) {
        int row = beeRow - 1;
        int col = beeCol;
        if (!isBeeOut(col, row, matrix.length)) {
            if (matrix[row][col] == 'f') {
                pollinateCount++;
            } else if (matrix[row][col] == 'O') {
                matrix[row][col] = '.';
                row--;
                if (matrix[row][col] == 'f') {
                    pollinateCount++;
                }
            }
            matrix[beeRow][beeCol] = '.';
            beeRow = row;
            beeCol = col;
            matrix[beeRow][beeCol] = 'B';
        } else {
            matrix[beeRow][beeCol] = '.';
            isOut = true;
        }
    }

    private static void moveDown(char[][] matrix) {

        int row = beeRow + 1;
        int col = beeCol;
        if (!isBeeOut(col, row, matrix.length)) {
            if (matrix[row][col] == 'f') {
                pollinateCount++;
            } else if (matrix[row][col] == 'O') {
                matrix[row][col] = '.';
                row++;
                if (matrix[row][col] == 'f') {
                    pollinateCount++;
                }
            }
            matrix[beeRow][beeCol] = '.';
            beeRow = row;
            beeCol = col;
            matrix[beeRow][beeCol] = 'B';
        } else {
            matrix[beeRow][beeCol] = '.';
            isOut = true;
        }
    }

    private static void moveLeft(char[][] matrix) {
        int row = beeRow;
        int col = beeCol - 1;
        if (!isBeeOut(col, row, matrix.length)) {
            if (matrix[row][col] == 'f') {
                pollinateCount++;
            } else if (matrix[row][col] == 'O') {
                matrix[row][col] = '.';
                col--;
                if (matrix[row][col] == 'f') {
                    pollinateCount++;
                }
            }
            matrix[beeRow][beeCol] = '.';
            beeRow = row;
            beeCol = col;
            matrix[beeRow][beeCol] = 'B';
        } else {
            isOut = true;
            matrix[beeRow][beeCol] = '.';
        }
    }

    private static void moveRight(char[][] matrix) {
        int row = beeRow;
        int col = beeCol + 1;
        if (!isBeeOut(col, row, matrix.length)) {
            if (matrix[row][col] == 'f') {
                pollinateCount++;
            } else if (matrix[row][col] == 'O') {
                matrix[row][col] = '.';
                col++;
                if (matrix[row][col] == 'f') {
                    pollinateCount++;
                }
            }
            matrix[beeRow][beeCol] = '.';
            beeRow = row;
            beeCol = col;
            matrix[beeRow][beeCol] = 'B';
        } else {
            isOut = true;
            matrix[beeRow][beeCol] = '.';
        }
    }

    private static boolean isBeeOut(int col, int row, int n) {
        return col < 0 || col >= n || row < 0 || row >= n;
    }

    private static void print(char[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }
}
