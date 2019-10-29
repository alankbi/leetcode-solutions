package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 54: Spiral Matrix
 */
public class SpiralMatrix {

    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null) {
            return new ArrayList<>();
        }

        List<Integer> order = new ArrayList<>();
        int rows = matrix.length;
        int cols = 0;
        int nIterations = (rows + 1) / 2;
        if (rows > 0) {
            cols = matrix[0].length;
            nIterations = Math.min(nIterations, (cols + 1) / 2);
        }

        for (int i = 0; i < nIterations; i++) {
            // Left to right
            for (int j = i; j < cols - i; j++) {
                order.add(matrix[i][j]);
            }

            // Top to bottom
            for (int j = i + 1; j < rows - i; j++) {
                order.add(matrix[j][cols - 1 - i]);
            }

            // Right to left
            for (int j = (cols - 1 - i) - 1; j >= i && rows - 1 - i > i; j--) {
                order.add(matrix[rows - 1 - i][j]);
            }

            // Bottom to top
            for (int j = (rows - 1 - i) - 1; j > i && cols - 1 - i > i; j--) {
                order.add(matrix[j][i]);
            }
        }


        return order;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 9},
                {4, 5, 6, 10},
                {7, 8, 9, 11},
                {12, 13, 14, 15}
        };
        List<Integer> result = new SpiralMatrix().spiralOrder(matrix);
        System.out.println(result);
    }
}
