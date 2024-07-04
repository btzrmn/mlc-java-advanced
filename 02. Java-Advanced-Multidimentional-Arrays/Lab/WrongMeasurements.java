package class02;

import java.util.*;

public class WrongMeasurements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];
        int[][] result = new int[rows][];

        for (int i = 0; i < rows; i++) {
            int[] line = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = line;
        }

        int[] valueCoordinate = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int row = valueCoordinate[0];
        int col = valueCoordinate[1];

        int wrongValue = matrix[row][col];

        for (int i = 0; i < matrix.length; i++) {
            int[] lineArr = new int[matrix[i].length];
            for (int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == wrongValue){
                    lineArr[j] = getCorrectValue(matrix, i, j, wrongValue);
                } else {
                    lineArr[j] = matrix[i][j];
                }
            }
            result[i] = lineArr;
        }


        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int getCorrectValue(int[][] matrix, int row, int col, int wrongValue) {
        int correctValue = 0;

        if (row > 0 && matrix[row - 1][col] != wrongValue) {
            correctValue += matrix[row - 1][col];
        }

        if (col < matrix[row].length - 1 && matrix[row][col + 1] != wrongValue) {
            correctValue += matrix[row][col + 1];
        }

        if (row < matrix.length - 1 && matrix[row + 1][col] != wrongValue) {
            correctValue += matrix[row + 1][col];
        }

        if (col > 0 && matrix[row][col - 1] != wrongValue) {
            correctValue += matrix[row][col - 1];
        }

        return correctValue;
    }
}
