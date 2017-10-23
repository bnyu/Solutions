import scala.collection.mutable

/** 77. Combinations
  * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
  * For example, If n = 4 and k = 2, a solution is: [[2,4],[3,4],[2,3],[1,2],[1,3],[1,4]]
  */
object Combinations {
  def combine(n: Int, k: Int): List[List[Int]] = {
    var element = 0

    def ++(e: Int): Int = {
      element = e + 1
      element
    }

    val elements = List.fill(n)(++(element))
    val ans = new mutable.MutableList[List[Int]]

    def addSubSet(list: List[Int], startIndex: Int, leftNum: Int): Unit = {
      if (leftNum <= 0)
        ans += list
      else if (startIndex + leftNum <= n)
        for (i <- startIndex until n)
          addSubSet(elements(i) :: list, i + 1, leftNum - 1)
    }

    if (k < n)
      addSubSet(Nil, 0, k)
    else if (k == n)
      ans += elements
    ans.toList
  }
}
