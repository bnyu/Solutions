import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 37. Sudoku Solver
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 */
public class Solution037 {
    private final Map<Integer, Set<Character>> defaultBoardMap = new HashMap<>();
    private final Map<Integer, Set<Character>> boardMap = new HashMap<>();
    private final char[] nums = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    private final Set<Integer> needSolve = new HashSet<>();


    public void solveSudoku(char[][] board) {
        char[][] solve = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                solve[i][j] = c;
                if (c == '.') {
                    needSolve.add(9 * i + j);
                    continue;
                }
                changeBoard(i, j, c, defaultBoardMap, true);
            }
        }
        for (int i = 0; i < 27; i++) {
            Set<Character> newSet = new HashSet<>();
            Set<Character> set = defaultBoardMap.get(i);
            if (set != null)
                newSet.addAll(set);
            boardMap.put(i, newSet);
        }

        if (guessOneByOne(solve, 0))
            for (int i = 0; i < 9; i++)
                System.arraycopy(solve[i], 0, board[i], 0, 9);
    }

    private void changeBoard(int index, char[][] solve, boolean add) {
        int row = index / 9;
        int col = index % 9;
        changeBoard(row, col, solve[row][col], boardMap, add);
    }

    private void changeBoard(int i, int j, char c, Map<Integer, Set<Character>> map, boolean add) {
        Set<Character> set;
        int index;
        for (int k = 0; k < 3; k++) {
            switch (k) {
                case 0:
                    index = i;
                    break;
                case 1:
                    index = 9 + j;
                    break;
                default:
                    index = 18 + i / 3 * 3 + j / 3;
                    break;
            }
            if (map.containsKey(index))
                set = map.get(index);
            else {
                set = new HashSet<>();
                map.put(index, set);
            }
            if (add) set.add(c);
            else set.remove(c);
        }
    }

    private boolean guessOneByOne(char[][] solve, int index) {
        if (index == 81)
            return true;
        if (needSolve.contains(index)) {
            int row = index / 9;
            int col = index % 9;
            //新的栈用新的棋盘的判断
            for (int i = 0; i < 27; i++) {
                Set<Character> newSet = boardMap.get(i);
                newSet.clear();
                Set<Character> defaultSet = defaultBoardMap.get(i);
                if (defaultSet != null)
                    newSet.addAll(defaultSet);
            }
            for (int solvedIndex : needSolve) {
                if (solvedIndex < index) {
                    changeBoard(solvedIndex, solve, true);
                }
            }
            //从1到9依次猜
            for (int i = 0; i < 9; i++) {
                char n = nums[i];
                if (guess(n, row, col)) {
                    solve[row][col] = n;
                    int nextIndex = index + 1;
                    if (guessOneByOne(solve, nextIndex))
                        return true;
                    else
                        //删除此位置不合理猜测
                        changeBoard(row, col, n, boardMap, false);
                }
            }
            //此位置无合理猜测 删除上一个位置不合理猜测
            return false;
        } else {
            int nextIndex = index + 1;
            for (; nextIndex < 81; nextIndex++)
                if (needSolve.contains(nextIndex))
                    break;
            return guessOneByOne(solve, nextIndex);
        }
    }

    private boolean guess(char c, int i, int j) {
        Set<Character> set = boardMap.get(i);
        if (set.contains(c))
            return false;
        Set<Character> set1 = boardMap.get(9 + j);
        if (set1.contains(c))
            return false;
        Set<Character> set2 = boardMap.get(18 + i / 3 * 3 + j / 3);
        if (set2.contains(c))
            return false;
        set.add(c);
        set1.add(c);
        set2.add(c);
        return true;
    }

}

