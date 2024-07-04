package class02;

import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] chess = new char[8][8];

        for (int i = 0; i < 8; i++) {
            String[] line = scanner.nextLine().split(" ");
            for (int j = 0; j < 8; j++) {
                chess[i][j] = line[j].charAt(0);
            }
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chess[i][j] == 'q' && isQueenValid(chess, i, j)) {
                    System.out.println(i + " " + j);
                    i = 8;
                    j = 8;
                }
            }
        }
    }

    private static boolean isQueenValid(char[][] chess, int row, int col) {

        // zuun  shalgah
        int i = col - 1;
        while (i >= 0) {
            if (chess[row][i] == 'q') {
                return false;
            }
            i--;
        }

        // deeshee shalgah
        i = row - 1;
        while (i >= 0) {
            if (chess[i][col] == 'q') {
                return false;
            }
            i--;
        }

        // baruun  shalgah
        i = col + 1;
        while (i < 8) {
            if (chess[row][i] == 'q') {
                return false;
            }
            i++;
        }

        // dooshoo shalgah
        i = row + 1;
        while (i < 8) {
            if (chess[i][col] == 'q') {
                return false;
            }
            i++;
        }

        // zuun deeshee shalgah
        i = row - 1;
        int j = col - 1;
        while (i >= 0 && j >= 0) {
            if (chess[i][j] == 'q') {
                return false;
            }
            i--;
            j--;
        }

        // baruun deeshee shalgah
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < 8) {
            if (chess[i][j] == 'q') {
                return false;
            }
            i--;
            j++;
        }

        // baruun dooshoo shalgah
        i = row + 1;
        j = col + 1;
        while (i < 8 && j < 8) {
            if (chess[i][j] == 'q') {
                return false;
            }
            i++;
            j++;
        }

        // zuun dooshoo shalgah
        i = row + 1;
        j = col - 1;
        while (i < 8 && j >= 0) {
            if (chess[i][j] == 'q') {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
