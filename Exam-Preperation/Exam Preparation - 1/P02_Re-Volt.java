import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int countCommands = Integer.parseInt(scanner.nextLine());

        int playerRow = 0;
        int playerCol = 0;

        char[][] matrix = new char[n][n];
        for (int row = 0; row < matrix.length; row++) {
            String input = scanner.nextLine();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = input.charAt(col);
                if (input.charAt(col) == 'f') {
                    playerRow = row;
                    playerCol = col;
                }

            }
        }

        boolean isFound = false;

//        if ('T') { do nothing }
//        if ('B') { move again }
//        if ('F') { finish; break; }

        while (countCommands-- > 0 && !isFound) {
            String command = scanner.nextLine();
            switch (command) {
                case "up":
                    //                    playerRow -= 1;
                    if (isValidIndex(playerRow - 1, playerCol, matrix)) {
                        if (matrix[playerRow - 1][playerCol] == '-') {
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow - 1][playerCol] = 'f';
                            playerRow -= 1;
                        } else if (matrix[playerRow - 1][playerCol] == 'B') {
                            matrix[playerRow][playerCol] = '-';
                            playerRow -= 1;
                            if (isValidIndex(playerRow - 1, playerCol, matrix)) {
                                if (matrix[playerRow - 1][playerCol] == 'F') {
                                    matrix[playerRow - 1][playerCol] = 'f';
                                    isFound = true;
                                    break;
                                } else {
                                    matrix[playerRow - 1][playerCol] = 'f';
                                    playerRow -= 1;
                                }
                            } else {
                                playerRow = matrix.length - 1;
                                if (matrix[playerRow][playerCol] == 'F') {
                                    matrix[playerRow][playerCol] = 'f';
                                    isFound = true;
                                    break;
                                } else {
                                    matrix[playerRow][playerCol] = 'f';
                                }
                            }
                        } else if (matrix[playerRow - 1][playerCol] == 'F') {
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow - 1][playerCol] = 'f';
                            isFound = true;
                            break;
                        }
                    } else {
                        playerRow = matrix.length - 1;
                        if (matrix[playerRow][playerCol] == '-') {
                            matrix[0][playerCol] = '-';
                            matrix[playerRow][playerCol] = 'f';
                        } else if (matrix[playerRow][playerCol] == 'B') {
                            matrix[0][playerCol] = '-';
                            if (matrix[playerRow - 1][playerCol] == 'F') {
                                matrix[playerRow - 1][playerCol] = 'f';
                                isFound = true;
                                break;
                            } else {
                                matrix[playerRow - 1][playerCol] = 'f';
                                playerRow -= 1;
                            }
                        } else if (matrix[playerRow][playerCol] == 'F') {
                            matrix[0][playerCol] = '-';
                            matrix[playerRow][playerCol] = 'f';
                            isFound = true;
                            break;
                        }
                    }

                    break;
                case "down":
//                    playerRow += 1;
                    if (isValidIndex(playerRow + 1, playerCol, matrix)) {
                        if (matrix[playerRow + 1][playerCol] == '-') {
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow + 1][playerCol] = 'f';
                            playerRow += 1;
                        } else if (matrix[playerRow + 1][playerCol] == 'B') {
                            matrix[playerRow][playerCol] = '-';
                            playerRow += 1;
                            if (isValidIndex(playerRow + 1, playerCol, matrix)) {
                                if (matrix[playerRow + 1][playerCol] == 'F') {
                                    matrix[playerRow + 1][playerCol] = 'f';
                                    isFound = true;
                                    break;
                                } else {
                                    matrix[playerRow + 1][playerCol] = 'f';
                                    playerRow += 1;
                                }
                            } else {
                                playerRow = 0;
                                if (matrix[playerRow][playerCol] == 'F') {
                                    matrix[playerRow][playerCol] = 'f';
                                    isFound = true;
                                    break;
                                } else {
                                    matrix[playerRow][playerCol] = 'f';
                                }
                            }
                        } else if (matrix[playerRow + 1][playerCol] == 'F') {
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow + 1][playerCol] = 'f';
                            isFound = true;
                            break;
                        }
                    } else {
                        playerRow = 0;
                        if (matrix[playerRow][playerCol] == '-') {
                            matrix[matrix.length - 1][playerCol] = '-';
                            matrix[playerRow][playerCol] = 'f';
                        } else if (matrix[playerRow][playerCol] == 'B') {
                            matrix[matrix.length - 1][playerCol] = '-';
                            if (matrix[playerRow + 1][playerCol] == 'F') {
                                matrix[playerRow + 1][playerCol] = 'f';
                                isFound = true;
                                break;
                            } else {
                                matrix[playerRow + 1][playerCol] = 'f';
                                playerRow += 1;
                            }
                        } else if (matrix[playerRow][playerCol] == 'F') {
                            matrix[matrix.length - 1][playerCol] = '-';
                            matrix[playerRow][playerCol] = 'f';
                            isFound = true;
                            break;
                        }
                    }

                    break;
                case "left":
//                    playerCol -= 1;
                    if (isValidIndex(playerRow, playerCol - 1, matrix)) {
                        if (matrix[playerRow][playerCol - 1] == '-') {
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow][playerCol - 1] = 'f';
                            playerCol -= 1;
                        } else if (matrix[playerRow][playerCol - 1] == 'B') {
                            matrix[playerRow][playerCol] = '-';
                            playerCol -= 1;
                            if (isValidIndex(playerRow, playerCol - 1, matrix)) {
                                if (matrix[playerRow][playerCol - 1] == 'F') {
                                    matrix[playerRow][playerCol - 1] = 'f';
                                    isFound = true;
                                    break;
                                } else {
                                    matrix[playerRow][playerCol - 1] = 'f';
                                    playerCol -= 1;
                                }
                            } else {
                                playerCol = matrix[playerRow].length - 1;
                                if (matrix[playerRow][playerCol] == 'F') {
                                    matrix[playerRow][playerCol] = 'f';
                                    isFound = true;
                                    break;
                                } else {
                                    matrix[playerRow][playerCol] = 'f';
                                }
                            }
                        } else if (matrix[playerRow][playerCol - 1] == 'F') {
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow][playerCol - 1] = 'f';
                            isFound = true;
                            break;
                        }
                    } else {
                        playerCol = matrix[playerRow].length - 1;
                        if (matrix[playerRow][playerCol] == '-') {
                            matrix[playerRow][0] = '-';
                            matrix[playerRow][playerCol] = 'f';
                        } else if (matrix[playerRow][playerCol] == 'B') {
                            matrix[playerRow][0] = '-';
                            if ( matrix[playerRow][playerCol - 1] == 'F') {
                                matrix[playerRow][playerCol - 1] = 'f';
                                isFound = true;
                                break;
                            } else {
                                matrix[playerRow][playerCol - 1] = 'f';
                                playerCol -= 1;

                            }
                        } else if (matrix[playerRow][playerCol] == 'F') {
                            matrix[playerRow][0] = '-';
                            matrix[playerRow][playerCol] = 'f';
                            isFound = true;
                            break;
                        }
                    }

                    break;
                case "right":
//                    playerCol += 1;
                    if (isValidIndex(playerRow, playerCol + 1, matrix)) {
                        if (matrix[playerRow][playerCol + 1] == '-') {
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow][playerCol + 1] = 'f';
                            playerCol += 1;
                        } else if (matrix[playerRow][playerCol + 1] == 'B') {
                            matrix[playerRow][playerCol] = '-';
                            playerCol += 1;
                            if (isValidIndex(playerRow, playerCol + 1, matrix)) {
                                if (matrix[playerRow][playerCol + 1] == 'F') {
                                    matrix[playerRow][playerCol + 1] = 'f';
                                    isFound = true;
                                    break;
                                } else {
                                    matrix[playerRow][playerCol + 1] = 'f';
                                    playerCol += 1;
                                }
                            } else {
                                playerCol = 0;
                                if (matrix[playerRow][playerCol] == 'F') {
                                    matrix[playerRow][playerCol] = 'f';
                                    isFound = true;
                                    break;
                                } else {
                                    matrix[playerRow][playerCol] = 'f';
                                }
                            }
                        } else if (matrix[playerRow][playerCol + 1] == 'F') {
                            matrix[playerRow][playerCol] = '-';
                            matrix[playerRow][playerCol + 1] = 'f';
                            System.out.println("Player won!");
                            break;
                        }
                    } else {
                        playerCol = 0;
                        if (matrix[playerRow][playerCol] == '-') {
                            matrix[playerRow][matrix[playerRow].length - 1] = '-';
                            matrix[playerRow][playerCol] = 'f';
                        } else if (matrix[playerRow][playerCol] == 'B') {
                            matrix[playerRow][matrix[playerRow].length - 1] = '-';
                            if (matrix[playerRow][playerCol + 1] == 'F') {
                                matrix[playerRow][playerCol + 1] = 'f';
                                isFound = true;
                                break;
                            } else {
                                matrix[playerRow][playerCol + 1] = 'f';
                                playerCol += 1;
                            }
                        } else if (matrix[playerRow][playerCol] == 'F') {
                            matrix[playerRow][matrix[playerRow].length - 1] = '-';
                            matrix[playerRow][playerCol] = 'f';
                            isFound = true;
                            break;
                        }
                    }
                    break;
            }
        }


        if (!isFound) {
            System.out.println("Player lost!");
        } else {
            System.out.println("Player won!");
        }
        printMatrix(matrix);


    }

    private static boolean isValidIndex(int playerRow, int playerCol, char[][] matrix) {
        return playerRow >= 0 && playerRow < matrix.length
                && playerCol >= 0 && playerCol < matrix[playerRow].length;
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }


}