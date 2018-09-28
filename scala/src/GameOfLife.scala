/** 289. Game of Life
  * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
  * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
  * 1. Any live cell with fewer than two live neighbors dies, as if caused by under-population.
  * 2. Any live cell with two or three live neighbors lives on to the next generation.
  * 3. Any live cell with more than three live neighbors dies, as if by over-population..
  * 4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
  * Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
  * Example:
  * Input:
  * [
  * [0,1,0],
  * [0,0,1],
  * [1,1,1],
  * [0,0,0]
  * ]
  * Output:
  * [
  * [0,0,0],
  * [1,0,1],
  * [0,1,1],
  * [0,1,0]
  * ]
  */
object GameOfLife {
  def gameOfLife(board: Array[Array[Int]]): Unit = {
    val row = board.length
    val column = board(0).length
    val neighbors = Array.fill(row)(Array.fill(column)(0))

    def addLive(i: Int, j: Int): Unit = {
      if (i > 0) neighbors(i - 1)(j) += 1
      if (j > 0) neighbors(i)(j - 1) += 1
      if (i > 0 && j > 0) neighbors(i - 1)(j - 1) += 1
      if (i < row - 1) neighbors(i + 1)(j) += 1
      if (j < column - 1) neighbors(i)(j + 1) += 1
      if (i < row - 1 && j < column - 1) neighbors(i + 1)(j + 1) += 1
      if (i > 0 && j < column - 1) neighbors(i - 1)(j + 1) += 1
      if (i < row - 1 && j > 0) neighbors(i + 1)(j - 1) += 1
    }

    def update(i: Int, j: Int): Unit = {
      if (board(i)(j) == 1) {
        if (neighbors(i)(j) < 2 || neighbors(i)(j) > 3) board(i)(j) = 0
      } else {
        if (neighbors(i)(j) == 3) board(i)(j) = 1
      }
    }

    for (i <- 0 until row; j <- 0 until column) {
      if (board(i)(j) == 1) {
        addLive(i, j)
      }
    }
    for (i <- 0 until row; j <- 0 until column) {
      update(i, j)
    }
  }
}
