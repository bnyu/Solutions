import scala.collection.mutable

/** 312. Burst Balloons
  * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
  * Find the maximum coins you can collect by bursting the balloons wisely.
  * Note:You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them. 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100
  * Example: Input: [3,1,5,8]  Output: 167
  * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
  * coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
  */
object BurstBalloons {

  class Node(val v: Int, val i: Int) {
    def this() {
      this(1, -1)
      this.edge = true
    }

    var edge = false
    var left: Node = _
    var right: Node = _
  }

  def maxCoins(nums: Array[Int]): Int = {
    val first = new Node()
    var now = first
    var num = 0
    for (i <- nums.indices) {
      val n = nums(i)
      if (n > 0) {
        val node = new Node(n, i)
        node.left = now
        now.right = node
        now = node
        num += 1
      }
    }
    now.right = new Node()
    now.right.left = now
    val cache = new mutable.HashMap[String, Int]()

    def cal(size: Int): Int = {
      if (size > 0) {
        var node = first.right
        val str = new StringBuilder()
        while (!node.edge) {
          str.append(node.i)
          str.append("-")
          node = node.right
        }
        cache.getOrElseUpdate(str.toString(), {
          var node = first.right
          val s = size - 1
          var max = 0
          while (!node.edge) {
            val left = node.left
            val right = node.right
            val x = left.v * node.v * right.v
            left.right = right
            right.left = left
            val z = x + cal(s)
            left.right = node
            right.left = node
            node = right
            if (z > max) max = z
          }
          max
        })
      } else {
        0
      }
    }

    cal(num)
  }
}
