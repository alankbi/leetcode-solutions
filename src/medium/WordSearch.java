package medium;

/**
 * Problem 79: Word Search
 */
public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (word == null || word.isEmpty()) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (word.charAt(0) == board[i][j] && dfs(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, int i, int j, String word, int index) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '.') {
            return false;
        }

        if (word.charAt(index) == board[i][j]) {
            if (index == word.length() - 1) {
                return true;
            }

            char temp = board[i][j];
            board[i][j] = '.';

            boolean ans = dfs(board, i + 1, j, word, index + 1) ||
                    dfs(board, i - 1, j, word, index + 1) ||
                    dfs(board, i, j + 1, word, index + 1) ||
                    dfs(board, i, j - 1, word, index + 1);

            board[i][j] = temp;
            return ans;
        }

        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'},
        };

        boolean result = new WordSearch().exist(board, "ABCCED");
        System.out.println(result);
    }
}
