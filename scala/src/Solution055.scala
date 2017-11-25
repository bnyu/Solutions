import scala.annotation.tailrec

/**
  * 55. Jump Game
  * Given an array of non-negative integers, you are initially positioned at the first index of the array.
  * Each element in the array represents your maximum jump length at that position.
  * Determine if you are able to reach the last index.
  * For example: A = [2,3,1,1,4], return true. A = [3,2,1,0,4], return false.
  */
object Solution055 {
  // 和S045.kt非常类似 换一种 more functional style 算是第一行Scala 哈
  def canJump(nums: Array[Int]): Boolean = {

    @tailrec
    def jump(nums: Array[Int]): Boolean = {
      //修改 不需要yield 只需要最远的那个
      val index = nums.indices.reverse.find(i => nums(i) > i)
      if (index.isEmpty)
        nums.isEmpty
      else
        jump(nums.drop(index.get + 1))
    }

    jump(nums.reverse.tail)
  }
}

