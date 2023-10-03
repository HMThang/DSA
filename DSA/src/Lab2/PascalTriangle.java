package Lab2;

import java.util.Arrays;

public class PascalTriangle {
    public static void printPascalTriangle(int row) {
        if (row == 0) {
            return;
        }
        printPascalTriangle(row - 1);
        System.out.println(Arrays.toString(getPascalTriangle(row)));
    }

    public static int[] getPascalTriangle(int n) {
        if (n == 1)
            return new int[]{1};
        else {
            int[] prevRow = getPascalTriangle(n - 1);
            return generateNextRow(prevRow);
        }
    }

    public static int[] generateNextRow(int[] prevRow) {
        int[] nextRow = new int[prevRow.length + 1];
        nextRow[0] = 1;
        nextRow[nextRow.length - 1] = 1;
        for (int i = 1; i < nextRow.length - 1; i++) {
            nextRow[i] = prevRow[i - 1] + prevRow[i];
        }
        return nextRow;
    }

    public static void printX(int n) {
        if (n == 0) {
            return;
        }
        System.out.print("X");
        printX(n - 1);
    }

    public static void printSpaces(int count) {
        if (count == 0) {
            return;
        }
        System.out.print(" ");
        printSpaces(count - 1);
    }

    public static void drawPrramidHelper(int start, int bound) {
        if (start > bound) return;
        printSpaces(bound - start + 1);
        printX(2 * start - 1);
        System.out.println();
        drawPrramidHelper(start + 1, bound);
    }

    public static void drawPyramid(int n) {
        if (n == 0) {
            return;
        }
        drawPrramidHelper(1, n);
        System.out.println();
    }

    public static void main(String[] args) {
        printPascalTriangle(5);
        drawPyramid(4);
    }

}
