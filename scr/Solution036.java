import java.util.HashSet;
import java.util.Set;

/**
 * 36. Valid Sudoku
 * Determine if a Sudoku is valid.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
public class Solution036 {
    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9)
            return false;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            if (board[i].length != 9)
                return false;
            for (int j = 0; j < 9; j++) {
                if (!isValid(board, i, j, set))
                    return false;
            }
            set.clear();
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!isValid(board, j, i, set))
                    return false;
            }
            set.clear();
        }

        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 9; j++) {
                    if (!isValid(board, i * 3 + j / 3, k * 3 + j % 3, set)) {
                        return false;
                    }
                }
                set.clear();
            }
        }
        return true;
    }


    private boolean isValid(char[][] board, int i, int j, Set<Character> set) {
        char dot = '.';
        char c = board[i][j];
        if (c == dot)
            return true;
        if (set.contains(c))
            return false;
        else
            set.add(c);
        return true;
    }

}