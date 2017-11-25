/**
  * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
  * You may assume that the intervals were initially sorted according to their start times.
  * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
  * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16]. This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
  */
object Solution057 {
  def insert(intervals: List[Interval], newInterval: Interval): List[Interval] = {
    //插入的左部分 不包括重叠
    val leftNum = intervals.indexWhere(i => i.end >= newInterval.start)
    val leftIntervals = if (leftNum < 0) intervals else intervals.take(leftNum)
    val leftIndex = if (leftIntervals.isEmpty) -1 else leftNum
    //插入的右部分 不包括重叠
    val (rightIndex, rightIntervals) = if (leftNum < 0) (-1, Nil) else {
      val rightIndex = intervals.indexWhere(i => i.start > newInterval.end, from = leftNum)
      val rightIntervals = if (rightIndex < 0) Nil else intervals.drop(rightIndex)
      (if (rightIndex < 0) -1 else rightIndex - 1, rightIntervals)
    }
    //产生重叠部分
    val mayOverlap = (leftIndex, rightIndex) match {
      case (-1, -1) => List(newInterval)
      case (-1, _) => List(newInterval, intervals(rightIndex))
      case (_, -1) => List(intervals(leftIndex), newInterval)
      case _ => List(intervals(leftIndex), newInterval, intervals(rightIndex))
    }
    //用s56合并 虽然最多3个
    val midInterval = Solution056 merge mayOverlap
    leftIntervals ++ midInterval ++ rightIntervals
  }
}

