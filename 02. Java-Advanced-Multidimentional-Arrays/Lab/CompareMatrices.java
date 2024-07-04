package class02;

import java.util.Arrays;
import java.util.Scanner;

public class CompareMatrices {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] firstMatrix = insertMatrix(scanner);
        int[][] secondMatrix = insertMatrix(scanner);

        boolean isEqual = matricesAreEquals(firstMatrix, secondMatrix);
        if (isEqual) {
            System.out.println("equal");
        } else {
            System.out.println("not equal");
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

    private static boolean matricesAreEquals(int[][] firstMatrix, int[][] secondMatrix) {
        // 2x3 2x3
        if (firstMatrix.length != secondMatrix.length || firstMatrix[0].length != secondMatrix[0].length) {
            // 2x3 2x2
            return false;
        }

        // firstMatrix[1][2] -> 1 , secondMatrix[1][2] -> 1
        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[0].length; j++) {
                if (firstMatrix[i][j] != secondMatrix[i][j]) {
                    // firstMatrix[1][2] -> 2 , secondMatrix[1][2] -> 3
                    return false;
                }
            }
        }
        return true;
    }
}
