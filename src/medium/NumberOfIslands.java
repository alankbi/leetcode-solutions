package medium;

/**
 * Problem 200: Number of Islands
 */
public class NumberOfIslands {

    public int numIslands(char[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    fill(grid, i, j);
                }
            }
        }
        return count;
    }

    private void fill(char[][] grid, int r, int c) {
        if (r >= 0 && r < grid.length && c >= 0 && c < grid[0].length && grid[r][c] == '1') {
            grid[r][c] = '0';
            fill(grid, r - 1, c);
            fill(grid, r + 1, c);
            fill(grid, r, c - 1);
            fill(grid, r, c + 1);
        }
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'},
        };

        int result = new NumberOfIslands().numIslands(grid);
        System.out.println(result);
    }
}
