/**
 * 36. Valid Sudoku
 * Determine if a Sudoku is valid.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
class Solution036 {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        if (board.size != 9)
            return false
        for (i in 0..8)
            if (board[i].size != 9)
                return false
        //行
        val set = HashSet<Char>()
        //列
        val set1 = HashSet<Char>()
        //块
        val set2 = HashSet<Char>()
        for (i in 0..8) {
            for (j in 0..8) {
                if (!isValid(board, i, j, set))
                    return false
                if (!isValid(board, j, i, set1))
                    return false
                if (!isValid(board, i % 3 * 3 + j / 3, i / 3 * 3 + j % 3, set2))
                    return false
            }
            set.clear()
            set1.clear()
            set2.clear()
        }
        return true
    }

    private fun isValid(board: Array<CharArray>, i: Int, j: Int, set: MutableSet<Char>): Boolean {
        val dot = '.'
        val c = board[i][j]
        if (c == dot)
            return true
        if (set.contains(c))
            return false
        else
            set.add(c)
        return true
    }
}
