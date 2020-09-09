package medium;

/**
 * Problem 794: Valid Tic-Tac-Toe State
 */
public class ValidTicTacToe {

    public boolean validTicTacToe(String[] board) {
        int xCount = 0;
        int oCount = 0;

        // Get counts of X and Os
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'X') {
                    xCount++;
                } else if (board[i].charAt(j) == 'O') {
                    oCount++;
                }
            }
        }

        // Players aren't taking turns moving
        if (!(xCount == oCount || xCount == oCount + 1)) {
            return false;
        }

        boolean xWins = wins(board, 'X');
        boolean oWins = wins(board, 'O');

        // Both players can't win
        if (xWins && oWins) {
            return false;
        }

        // Winner must play last
        if (xWins && xCount != oCount + 1 || oWins && xCount != oCount) {
            return false;
        }

        // Valid game
        return true;
    }

    private boolean wins(String[] board, char player) {
        for (int i = 0; i < board.length; i++) {
            String row = board[i];
            // Check row
            if (row.charAt(0) == player &&
                    row.charAt(1) == player &&
                    row.charAt(2) == player) {

                return true;
            }
            // Check column
            if (board[0].charAt(i) == player &&
                    board[1].charAt(i) == player &&
                    board[2].charAt(i) == player) {

                return true;
            }
        }

        // Check diagonals
        if ((board[0].charAt(0) == player &&
                board[1].charAt(1) == player &&
                board[2].charAt(2) == player) ||

                (board[0].charAt(2) == player &&
                        board[1].charAt(1) == player &&
                        board[2].charAt(0) == player)) {

            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String[] board = {"O  ", "   ", "   "};

        boolean result = new ValidTicTacToe().validTicTacToe(board);
        System.out.println(result);
    }
}
