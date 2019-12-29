package medium;

import java.util.Arrays;

/**
 * Problem 73: Set Matrix Zeroes
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return;
        }

        boolean zeroColumn = false;
        boolean zeroRow = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;

                    if (i == 0) {
                        zeroColumn = true;
                    }
                    if (j == 0) {
                        zeroRow = true;
                    }
                }
            }
        }

        for (int i = matrix.length - 1; i > 0; i--) {
            if (matrix[i][0] == 0) {
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int j = matrix[0].length - 1; j > 0; j--) {
            if (matrix[0][j] == 0) {
                for (int i = 0; i < matrix.length; i++) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (zeroRow) {
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
        if (zeroColumn) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1},
        };

        new SetMatrixZeroes().setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
}
