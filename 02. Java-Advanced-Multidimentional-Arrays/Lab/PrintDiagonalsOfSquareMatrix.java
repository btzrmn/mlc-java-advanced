package class02;

import java.util.Arrays;
import java.util.Scanner;

public class PrintDiagonalsOfSquareMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = insertMatrix(scanner);
        int row = 0;
        int col = 0;
        while (row < matrix.length && col < matrix.length) {
            System.out.print(matrix[row][col] + " ");
            row++;
            col++;
        }
        System.out.println();
        row = matrix.length - 1;
        col = 0;
        while (row >= 0 && col < matrix.length) {
            System.out.print(matrix[row][col] + " ");
            row--;
            col++;
        }
    }

    private static int[][] insertMatrix(Scanner scanner) {
        int line = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[line][line];

        for (int i = 0; i < line; i++) {
            int[] tokens = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < line; j++) {
                matrix[i][j] = tokens[j];
            }
        }
        return matrix;
    }
}
