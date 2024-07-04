package class02;

import java.util.Arrays;
import java.util.Scanner;

public class MaxSumSubmatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = insertMatrix(scanner);
        int[][] result  = new int[2][2];
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                int tempSum = matrix[i][j] + matrix[i][j+1] + matrix[i+1][j] + matrix[i+1][j+1];
                if(tempSum > sum) {
                    result[0][0] = matrix[i][j];
                    result[0][1] = matrix[i][j+1];
                    result[1][0] = matrix[i+1][j];
                    result[1][1] = matrix[i+1][j+1];
                    sum = tempSum;
                }
            }
        }

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(sum);
    }

    private static int[][] insertMatrix(Scanner scanner) {
        int[] dimention = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = dimention[0];
        int columns = dimention[1];
        int[][] matrix = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            int[] tokens = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = tokens[j];
            }
        }
        return matrix;
    }
}
