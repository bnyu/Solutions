import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 36. Valid Sudoku
 * Determine if a Sudoku is valid.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
class Solution036 {
    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9)
            return false;
        for (int i = 0; i < 9; i++)
            if (board[i].length != 9)
                return false;
        Set<Character> set = new HashSet<>();
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (!isValid(board, i, j, set))
                    return false;
                if (!isValid(board, j, i, set1))
                    return false;
                if (!isValid(board, i % 3 * 3 + j / 3, i / 3 * 3 + j % 3, set2))
                    return false;
            }
            set.clear();
            set1.clear();
            set2.clear();
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
