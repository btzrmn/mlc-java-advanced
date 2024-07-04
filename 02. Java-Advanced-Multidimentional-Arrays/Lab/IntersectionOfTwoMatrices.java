package class02;

import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        char[][] firstMat = new char[rows][cols];
        char[][] secondMat = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                firstMat[i][j] = line[j].charAt(0);
            }
        }

        for (int i = 0; i < rows; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < cols; j++) {
                secondMat[i][j] = line[j].charAt(0);
            }
        }

        char[][] intersection = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (firstMat[i][j] == secondMat[i][j]) {
                    intersection[i][j] = firstMat[i][j];
                } else {
                    intersection[i][j] = '*';
                }
            }
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(intersection[i][j] + " ");
            }
            System.out.println();
        }
    }
}
