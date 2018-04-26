import scala.collection.mutable

/** 174. Dungeon Game
  * The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.
  * The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.
  * Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).
  * In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.
  * Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.
  * For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
  * -2(K)	-3	 3
  * -5	  -10	 1
  * 10    30 	 -5(P)
  * Notes:
  * The knight's health has no upper bound.
  * Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.
  */
object DungeonGame {
  def calculateMinimumHP(dungeon: Array[Array[Int]]): Int = {
    val row = dungeon.length - 1
    val column = if (row >= 0) dungeon.head.length - 1 else -1
    if (row >= 0 && column >= 0) {
      val cache = new mutable.HashMap[(Int, Int), Int]()

      def calMinNeedHp(i: Int, k: Int): Int = {
        cache.getOrElseUpdate((i, k), {
          val nextNeed = if (i == row && k == column) {
            1
          } else if (i == row) {
            calMinNeedHp(i, k + 1)
          } else if (k == column) {
            calMinNeedHp(i + 1, k)
          } else {
            val right = calMinNeedHp(i + 1, k)
            val down = calMinNeedHp(i, k + 1)
            if (right <= down) right else down
          }
          val hp = nextNeed - dungeon(i)(k)
          if (hp <= 0) 1 else hp
        })
      }

      calMinNeedHp(0, 0)
    } else 1
  }
}

