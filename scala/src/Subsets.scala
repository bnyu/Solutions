import scala.collection.mutable

/** 78. Subsets
  * Given a set of distinct integers, nums, return all possible subsets (the power set).
  * Note: The solution set must not contain duplicate subsets.
  * For example, If nums = [1,2,3], a solution is: [ [3],[1],[2],[1,2,3],[1,3],[2,3],[1,2],[] ]
  */
object Subsets {
  def subsets(nums: Array[Int]): List[List[Int]] = {
    val ans = new mutable.MutableList[List[Int]]

    def addSubset(list: List[Int], startIndex: Int): Unit = {
      if (startIndex < nums.length) {
        for (i <- startIndex until nums.length) {
          val subset = nums(i) :: list
          ans += subset
          addSubset(subset, i + 1)
        }
      }
    }

    addSubset(Nil, 0)
    ans += Nil
    ans.toList
  }
}