/**
 * 37. Sudoku Solver
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 */
class Solution037 {
    private val boardMap = HashMap<Int, MutableSet<Char>>()
    private val nums = charArrayOf('1', '2', '3', '4', '5', '6', '7', '8', '9')
    private val needSolve = HashSet<Int>()

    fun solveSudoku(board: Array<CharArray>) {
        val solve = Array(9) { CharArray(9) }
        for (i in 0..8) {
            for (j in 0..8) {
                val c = board[i][j]
                solve[i][j] = c
                if (c == '.') {
                    needSolve.add(9 * i + j)
                    continue
                }
                changeBoard(i, j, c, true)
            }
        }
        //初始化空的横竖块
        for (i in 0..26)
            if (!boardMap.containsKey(i))
                boardMap.put(i, HashSet())
        //依次猜 若存在解 赋值给board
        if (guessOneByOne(solve, 0))
            for (i in 0..8)
                System.arraycopy(solve[i], 0, board[i], 0, 9)
    }

    //填写/擦除数字 改变boardMap
    private fun changeBoard(i: Int, j: Int, c: Char, add: Boolean) {
        var set: MutableSet<Char>
        var index: Int
        for (k in 0..2) {
            when (k) {
                0 -> index = i
                1 -> index = 9 + j
                else -> index = 18 + i / 3 * 3 + j / 3
            }
            if (boardMap.containsKey(index))
                set = boardMap[index]!!
            else {
                set = HashSet()
                boardMap.put(index, set)
            }
            if (add)
                set.add(c)
            else
                set.remove(c)
        }
    }

    private fun guessOneByOne(solve: Array<CharArray>, index: Int): Boolean {
        if (index == 81)
            return true
        if (needSolve.contains(index)) {
            val row = index / 9
            val col = index % 9
            //从1到9依次猜
            for (i in 0..8) {
                val n = nums[i]
                if (guess(n, row, col)) {
                    solve[row][col] = n
                    val nextIndex = index + 1
                    if (guessOneByOne(solve, nextIndex))
                        return true
                    //删除此位置不合理猜测
                    else
                        changeBoard(row, col, n, false)
                }
            }
            //此位置无合理猜测 删除上一个位置不合理猜测
            return false
        } else {
            //跳过不需要填写的位置
            var nextIndex = index + 1
            while (nextIndex < 81) {
                if (needSolve.contains(nextIndex))
                    break
                nextIndex++
            }
            return guessOneByOne(solve, nextIndex)
        }
    }

    //猜 合理则写入boardMap
    private fun guess(c: Char, i: Int, j: Int): Boolean {
        //横
        val set = boardMap[i]
        if (set!!.contains(c))
            return false
        //竖
        val set1 = boardMap[9 + j]
        if (set1!!.contains(c))
            return false
        //块
        val set2 = boardMap[18 + i / 3 * 3 + j / 3]
        if (set2!!.contains(c))
            return false
        set.add(c)
        set1.add(c)
        set2.add(c)
        return true
    }

}

