public class Test {
    public static void main(String[] args) {
        char[] board0 = {'5', '3', '.', '.', '7', '.', '.', '.', '.'};
        char[] board1 = {'6', '.', '.', '1', '9', '5', '.', '.', '.'};
        char[] board2 = {'.', '9', '8', '.', '.', '.', '.', '6', '.'};
        char[] board3 = {'8', '.', '.', '.', '6', '.', '.', '.', '3'};
        char[] board4 = {'4', '.', '.', '8', '.', '3', '.', '.', '1'};
        char[] board5 = {'7', '.', '.', '.', '2', '.', '.', '.', '6'};
        char[] board6 = {'.', '6', '.', '.', '.', '.', '2', '8', '.'};
        char[] board7 = {'.', '.', '.', '4', '1', '9', '.', '.', '5'};
        char[] board8 = {'.', '.', '.', '.', '8', '.', '.', '7', '9'};
        char[][] board = {board0, board1, board2, board3, board4, board5, board6, board7, board8};

        Solution037 solution037 = new Solution037();

        solution037.solveSudoku(board);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }

    }
}