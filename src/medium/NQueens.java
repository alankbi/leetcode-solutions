package medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 51: N-Queens
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];

        List<List<String>> solutions = new ArrayList<>();
        solveNQueens(board, n, 0, 0, solutions);
        return solutions;
    }

    private void solveNQueens(int[][] board, int n, int r, int c, List<List<String>> solutions) {
        if (n <= 0) {
            solutions.add(boardToList(board));
        }

        for (int i = r; i < board.length; i++) {
            int jStart = (i == r) ? c : 0;
            for (int j = jStart; j < board.length; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = -1; // Mark as queen
                    markBoard(board, i, j, 1);

                    if (j == board.length - 1) {
                        solveNQueens(board, n - 1, i + 1, 0, solutions);
                    } else {
                        solveNQueens(board, n - 1, i, j + 1, solutions);
                    }

                    board[i][j] = 0; // Undo marking
                    markBoard(board, i, j, -1);
                }
            }
        }
    }

    private void markBoard(int[][] board, int r, int c, int factor) {
        int i = r - 1;
        while (i >= 0) {
            board[i--][c] += factor;
        }

        i = r + 1;
        while (i < board.length) {
            board[i++][c] += factor;
        }

        int j = c - 1;
        while (j >= 0) {
            board[r][j--] += factor;
        }

        j = c + 1;
        while (j < board.length) {
            board[r][j++] += factor;
        }

        i = r - 1;
        j = c - 1;
        while (i >= 0 && j >= 0) {
            board[i--][j--] += factor;
        }

        i = r + 1;
        j = c - 1;
        while (i < board.length && j >= 0) {
            board[i++][j--] += factor;
        }

        i = r - 1;
        j = c + 1;
        while (i >= 0 && j < board.length) {
            board[i--][j++] += factor;
        }

        i = r + 1;
        j = c + 1;
        while (i < board.length && j < board.length) {
            board[i++][j++] += factor;
        }
    }

    private List<String> boardToList(int[][] board) {
        List<String> list = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == -1) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            list.add(sb.toString());
        }

        return list;
    }

    public static void main(String[] args) {
        List<List<String>> result = new NQueens().solveNQueens(4);
        System.out.println(result);
    }
}
