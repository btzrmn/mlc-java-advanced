import java.util.Scanner;

public class ReVolt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int countCommands = Integer.parseInt(scanner.nextLine());

        int x = 0;
        int y = 0;

        char[][] matrix = new char[n][n];
        for (int row = 0; row < matrix.length; row++) {
            String input = scanner.nextLine();
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = input.charAt(col);
                if (input.charAt(col) == 'f') {
                    x = row;
                    y = col;
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
                    //                    x -= 1;
                    if (isValidIndex(x - 1, y, matrix)) {
                        if (matrix[x - 1][y] == '-') {
                            matrix[x][y] = '-';
                            matrix[x - 1][y] = 'f';
                            x -= 1;
                        } else if (matrix[x - 1][y] == 'B') {
                            matrix[x][y] = '-';
                            x -= 1;
                            if (isValidIndex(x - 1, y, matrix)) {
                                if (matrix[x - 1][y] == 'F') {
                                    matrix[x - 1][y] = 'f';
                                    isFound = true;
                                    break;
                                } else {
                                    matrix[x - 1][y] = 'f';
                                    x -= 1;
                                }
                            } else {
                                x = matrix.length - 1;
                                if (matrix[x][y] == 'F') {
                                    matrix[x][y] = 'f';
                                    isFound = true;
                                    break;
                                } else {
                                    matrix[x][y] = 'f';
                                }
                            }
                        } else if (matrix[x - 1][y] == 'F') {
                            matrix[x][y] = '-';
                            matrix[x - 1][y] = 'f';
                            isFound = true;
                            break;
                        }
                    } else {
                        x = matrix.length - 1;
                        if (matrix[x][y] == '-') {
                            matrix[0][y] = '-';
                            matrix[x][y] = 'f';
                        } else if (matrix[x][y] == 'B') {
                            matrix[0][y] = '-';
                            if (matrix[x - 1][y] == 'F') {
                                matrix[x - 1][y] = 'f';
                                isFound = true;
                                break;
                            } else {
                                matrix[x - 1][y] = 'f';
                                x -= 1;
                            }
                        } else if (matrix[x][y] == 'F') {
                            matrix[0][y] = '-';
                            matrix[x][y] = 'f';
                            isFound = true;
                            break;
                        }
                    }

                    break;
                case "down":
//                    x += 1;
                    if (isValidIndex(x + 1, y, matrix)) {
                        if (matrix[x + 1][y] == '-') {
                            matrix[x][y] = '-';
                            matrix[x + 1][y] = 'f';
                            x += 1;
                        } else if (matrix[x + 1][y] == 'B') {
                            matrix[x][y] = '-';
                            x += 1;
                            if (isValidIndex(x + 1, y, matrix)) {
                                if (matrix[x + 1][y] == 'F') {
                                    matrix[x + 1][y] = 'f';
                                    isFound = true;
                                    break;
                                } else {
                                    matrix[x + 1][y] = 'f';
                                    x += 1;
                                }
                            } else {
                                x = 0;
                                if (matrix[x][y] == 'F') {
                                    matrix[x][y] = 'f';
                                    isFound = true;
                                    break;
                                } else {
                                    matrix[x][y] = 'f';
                                }
                            }
                        } else if (matrix[x + 1][y] == 'F') {
                            matrix[x][y] = '-';
                            matrix[x + 1][y] = 'f';
                            isFound = true;
                            break;
                        }
                    } else {
                        x = 0;
                        if (matrix[x][y] == '-') {
                            matrix[matrix.length - 1][y] = '-';
                            matrix[x][y] = 'f';
                        } else if (matrix[x][y] == 'B') {
                            matrix[matrix.length - 1][y] = '-';
                            if (matrix[x + 1][y] == 'F') {
                                matrix[x + 1][y] = 'f';
                                isFound = true;
                                break;
                            } else {
                                matrix[x + 1][y] = 'f';
                                x += 1;
                            }
                        } else if (matrix[x][y] == 'F') {
                            matrix[matrix.length - 1][y] = '-';
                            matrix[x][y] = 'f';
                            isFound = true;
                            break;
                        }
                    }

                    break;
                case "left":
//                    y -= 1;
                    if (isValidIndex(x, y - 1, matrix)) {
                        if (matrix[x][y - 1] == '-') {
                            matrix[x][y] = '-';
                            matrix[x][y - 1] = 'f';
                            y -= 1;
                        } else if (matrix[x][y - 1] == 'B') {
                            matrix[x][y] = '-';
                            y -= 1;
                            if (isValidIndex(x, y - 1, matrix)) {
                                if (matrix[x][y - 1] == 'F') {
                                    matrix[x][y - 1] = 'f';
                                    isFound = true;
                                    break;
                                } else {
                                    matrix[x][y - 1] = 'f';
                                    y -= 1;
                                }
                            } else {
                                y = matrix[x].length - 1;
                                if (matrix[x][y] == 'F') {
                                    matrix[x][y] = 'f';
                                    isFound = true;
                                    break;
                                } else {
                                    matrix[x][y] = 'f';
                                }
                            }
                        } else if (matrix[x][y - 1] == 'F') {
                            matrix[x][y] = '-';
                            matrix[x][y - 1] = 'f';
                            isFound = true;
                            break;
                        }
                    } else {
                        y = matrix[x].length - 1;
                        if (matrix[x][y] == '-') {
                            matrix[x][0] = '-';
                            matrix[x][y] = 'f';
                        } else if (matrix[x][y] == 'B') {
                            matrix[x][0] = '-';
                            if ( matrix[x][y - 1] == 'F') {
                                matrix[x][y - 1] = 'f';
                                isFound = true;
                                break;
                            } else {
                                matrix[x][y - 1] = 'f';
                                y -= 1;

                            }
                        } else if (matrix[x][y] == 'F') {
                            matrix[x][0] = '-';
                            matrix[x][y] = 'f';
                            isFound = true;
                            break;
                        }
                    }

                    break;
                case "right":
//                    y += 1;
                    if (isValidIndex(x, y + 1, matrix)) {
                        if (matrix[x][y + 1] == '-') {
                            matrix[x][y] = '-';
                            matrix[x][y + 1] = 'f';
                            y += 1;
                        } else if (matrix[x][y + 1] == 'B') {
                            matrix[x][y] = '-';
                            y += 1;
                            if (isValidIndex(x, y + 1, matrix)) {
                                if (matrix[x][y + 1] == 'F') {
                                    matrix[x][y + 1] = 'f';
                                    isFound = true;
                                    break;
                                } else {
                                    matrix[x][y + 1] = 'f';
                                    y += 1;
                                }
                            } else {
                                y = 0;
                                if (matrix[x][y] == 'F') {
                                    matrix[x][y] = 'f';
                                    isFound = true;
                                    break;
                                } else {
                                    matrix[x][y] = 'f';
                                }
                            }
                        } else if (matrix[x][y + 1] == 'F') {
                            matrix[x][y] = '-';
                            matrix[x][y + 1] = 'f';
                            System.out.println("Player won!");
                            break;
                        }
                    } else {
                        y = 0;
                        if (matrix[x][y] == '-') {
                            matrix[x][matrix[x].length - 1] = '-';
                            matrix[x][y] = 'f';
                        } else if (matrix[x][y] == 'B') {
                            matrix[x][matrix[x].length - 1] = '-';
                            if (matrix[x][y + 1] == 'F') {
                                matrix[x][y + 1] = 'f';
                                isFound = true;
                                break;
                            } else {
                                matrix[x][y + 1] = 'f';
                                y += 1;
                            }
                        } else if (matrix[x][y] == 'F') {
                            matrix[x][matrix[x].length - 1] = '-';
                            matrix[x][y] = 'f';
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

    private static boolean isValidIndex(int x, int y, char[][] matrix) {
        return x >= 0 && x < matrix.length
                && y >= 0 && y < matrix[x].length;
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