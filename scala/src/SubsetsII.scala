import scala.collection.mutable

/** 90. Subsets II
  * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
  * Note: The solution set must not contain duplicate subsets.
  */
object SubsetsII {
  def subsetsWithDup(nums: Array[Int]): List[List[Int]] = {
    if (nums.isEmpty) return Nil
    quickSort(nums, 0, nums.length - 1)
    val numNum = new mutable.MutableList[(Int, Int)]
    var pre = nums.head
    var preNum = 1
    for (n <- nums.tail) {
      if (n == pre)
        preNum += 1
      else {
        numNum += ((pre, preNum))
        pre = n
        preNum = 1
      }
    }
    numNum += ((nums.last, preNum))

    val ans = new mutable.MutableList[List[Int]]

    def addSubset(list: List[Int], numNum: List[(Int, Int)]): Unit = {
      if (numNum.nonEmpty) {
        var nextNum = numNum
        for ((n, nNum) <- numNum) {
          var subset = list
          nextNum = nextNum.tail
          // 只有这和Subsets.scala不同
          for (_ <- 1 to nNum) {
            subset = n :: subset
            ans += subset
            addSubset(subset, nextNum)
          }
        }
      }
    }

    addSubset(Nil, numNum.toList)
    ans += Nil
    ans.toList
  }

  def quickSort(nums: Array[Int], start: Int, end: Int): Unit = {
    var i = start
    var k = end
    val mid = nums(k)
    while (i < k) {
      while (nums(i) <= mid && i < k)
        i += 1
      if (i < k)
        nums(k) = nums(i)
      while (nums(k) >= mid && i < k)
        k -= 1
      if (i < k)
        nums(i) = nums(k)
      nums(k) = mid
    }
    if (k > start)
      quickSort(nums, start, k - 1)
    if (k < end)
      quickSort(nums, k + 1, end)
  }
}

