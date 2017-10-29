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
public class Solution036 {
    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9)
            return false;
        for (int i = 0; i < 9; i++)
            if (board[i].length != 9)
                return false;
        Map<Integer, Set<Character>> map = new HashMap<>();
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c != '.')
                    if (!isValid(i, j, c, map))
                        return false;
            }
        return true;
    }

    private boolean isValid(int i, int j, char c, Map<Integer, Set<Character>> map) {
        if (map.containsKey(i)) {
            if (map.get(i).contains(c))
                return false;
        } else map.put(i, new HashSet<>());

        if (map.containsKey(9 + j)) {
            if (map.get(9 + j).contains(c))
                return false;
        } else map.put(9 + j, new HashSet<>());

        if (map.containsKey(18 + i / 3 * 3 + j / 3)) {
            if (map.get(18 + i / 3 * 3 + j / 3).contains(c))
                return false;
        } else map.put(18 + i / 3 * 3 + j / 3, new HashSet<>());

        return true;
    }

}