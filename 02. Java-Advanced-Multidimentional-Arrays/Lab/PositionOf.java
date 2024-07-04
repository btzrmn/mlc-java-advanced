package class02;

import java.util.Arrays;
import java.util.Scanner;

public class PositionOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = insertMatrix(scanner);
        int searchNum = Integer.parseInt(scanner.nextLine());
        boolean isFound = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == searchNum) {
                    System.out.println(i + " " + j);
                    isFound = true;
                }
            }
        }

        if (!isFound) {
            System.out.println("not found");
        }
    }

    private static int[][] insertMatrix(Scanner scanner) {
        int[] dimention = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimention[0];
        int columns = dimention[1];
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            int[] tokens = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = tokens[j];
            }
        }
        return matrix;
    }
}
