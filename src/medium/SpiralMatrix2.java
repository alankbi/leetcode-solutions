package medium;

import java.util.Arrays;

/**
 * Problem 59: Spiral Matrix II
 */
public class SpiralMatrix2 {

    public int[][] generateMatrix(int n) {
        int[][] grid = new int[n][n];
        int val = 1;
        int i = 0;
        int j = 0;
        int direction = 0; // 0 -> right, 1 -> down, 2 -> left, 3 -> up

        while (val <= n * n) {
            grid[i][j] = val++;

            int[] next = next(i, j, direction);
            int newI = next[0];
            int newJ = next[1];
            if (isOutOfBounds(newI, newJ, grid)) {
                direction = (direction + 1) % 4;
                next = next(i, j, direction);
                newI = next[0];
                newJ = next[1];
                if (isOutOfBounds(newI, newJ, grid)) {
                    break;
                }
            }
            i = newI;
            j = newJ;
        }
        return grid;
    }

    private boolean isOutOfBounds(int i, int j, int[][] grid) {
        return i < 0 || i >= grid.length || j < 0 || j >= grid.length || grid[i][j] != 0;
    }

    private int[] next(int i, int j, int direction) {
        switch (direction) {
            case 0:
                return new int[] {i, j + 1};
            case 1:
                return new int[] {i + 1, j};
            case 2:
                return new int[] {i, j - 1};
            default:
                return new int[] {i - 1, j};
        }
    }

    public static void main(String[] args) {
        int[][] result = new SpiralMatrix2().generateMatrix(3);
        System.out.println(Arrays.deepToString(result));
    }
}
