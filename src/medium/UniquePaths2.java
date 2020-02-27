package medium;

/**
 * Problem 63: Unique Paths II
 */
public class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        obstacleGrid[0][0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1 && !(i == 0 && j == 0)) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }

                if (j - 1 >= 0) {
                    obstacleGrid[i][j] += obstacleGrid[i][j - 1];
                }
                if (i - 1 >= 0) {
                    obstacleGrid[i][j] += obstacleGrid[i - 1][j];
                }
            }
        }

        return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
    }

    public static void main(String[] args) {
        int[][] obstacleGrid = {
            {0, 0, 0},
            {0, 1, 0},
            {0, 0, 0},
        };

        int result = new UniquePaths2().uniquePathsWithObstacles(obstacleGrid);
        System.out.println(result);
    }
}
