package Lab5;

import java.util.Arrays;

public class Main {
    public static int[][] add(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            return new int[1][1];
        }

        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }

        return result;
    }

    public static int[][] subtract(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) {
            return new int[1][1];
        }
        int rows = a.length;
        int cols = a[0].length;
        int[][] result = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }

        return result;
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        // Check if the matrices are compatible for multiplication.
        if (a[0].length != b.length) {
            return new int[1][1];
        }

        // Create a new matrix to store the product.
        int[][] result = new int[a.length][b[0].length];

        // Iterate over each element of the two matrices and multiply them together.
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                for (int k = 0; k < a[0].length; k++) {
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }
        return result;
    }

    public static int[][] transpose(int[][] a) {
        // Create a new matrix to store the transpose.
        int[][] result = new int[a[0].length][a.length];

        // Iterate over each element of the matrix and copy it to the transpose,
        // but with the rows and columns swapped.
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                result[j][i] = a[i][j];
            }
        }

        // Return the result matrix.
        return result;
    }

    public static void main(String[] args) {
        int[][] matrix = {{7, 2}, {5, 3}};
        int[][] matrix1 = {{2, 1}, {3, 1}};
        System.out.println(Arrays.deepToString(add(matrix1, matrix)));
        System.out.println("---------------------------------------------------------------");
        System.out.println(Arrays.deepToString(subtract(matrix1, matrix)));
        System.out.println("---------------------------------------------------------------");
        System.out.println(Arrays.deepToString(multiply(matrix1, matrix)));
        System.out.println("---------------------------------------------------------------");
        System.out.println(Arrays.deepToString(transpose(matrix1)));
        System.out.println("---------------------------------------------------------------");
        char[][] board = {
                {'X', 'O', 'X'},
                {'X', 'X', 'O'},
                {'X', 'O', 'X'}
        };
        char[][] board1 = {
                {'X', 'O', 'X', 'X'},
                {'O', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'},
                {'X', 'O', 'X', 'X'}
        };
        TicTacToe toe = new TicTacToe(board);
        TicTacToe toe1 = new TicTacToe(board1);
        System.out.println(toe.checkDiagonals());
        System.out.println("---------------------------------------------------------------");
        System.out.println(toe.checkColumns());
        System.out.println("---------------------------------------------------------------");
        System.out.println(toe.checkRows());
        System.out.println("---------------------------------------------------------------");
        System.out.println(toe1.nxncheckDiagonals());
        System.out.println("---------------------------------------------------------------");
    }
}
