package medium;

/**
 * Problem 36: Valid Sudoku
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        // Check rows and columns
        for (int i = 0; i < 9; i++) {
            boolean[] foundRow = new boolean[10];
            boolean[] foundCol = new boolean[10];
            for (int j = 0; j < 9; j++) {
                int numRow = board[i][j] - '0';
                int numCol = board[j][i] - '0';

                // If isn't blank and the number already appears in the row or column
                if (numRow > 0 && foundRow[numRow] || numCol > 0 && foundCol[numCol]) {
                    return false;
                }
                if (numRow > 0) {
                    foundRow[numRow] = true;
                }
                if (numCol > 0) {
                    foundCol[numCol] = true;
                }
            }
        }

        // Check 3x3 squares
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                boolean[] found = new boolean[10];
                for (int k = i; k < i + 3; k++) {
                    for (int l = j; l < j + 3; l++) {
                        int num = board[k][l] - '0';

                        if (num > 0 && found[num]) {
                            return false;
                        }
                        if (num > 0) {
                            found[num] = true;
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
            {'5','3','.',  '.','7','.',  '.','.','.'},
            {'6','.','.',  '1','9','5',  '.','.','.'},
            {'.','9','8',  '.','.','.',  '.','6','.'},

            {'8','.','.',  '.','6','.',  '.','.','3'},
            {'4','.','.',  '8','.','3',  '.','.','1'},
            {'7','.','.',  '.','2','.',  '.','.','6'},

            {'.','6','.',  '.','.','.',  '2','8','.'},
            {'.','.','.',  '4','1','9',  '.','.','5'},
            {'.','.','.',  '.','8','.',  '.','7','9'}
        };

        boolean result = new ValidSudoku().isValidSudoku(board);
        System.out.println(result);
    }
}
