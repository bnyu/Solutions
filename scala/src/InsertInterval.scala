/**
  * 57. Insert Interval
  * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
  * You may assume that the intervals were initially sorted according to their start times.
  * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
  * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16]. This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
  */
object InsertInterval {
  def insert(intervals: List[Interval], newInterval: Interval): List[Interval] = {
    //插入的左部分 不包括重叠
    val leftNum = intervals.indexWhere(i => i.end >= newInterval.start)
    val leftIntervals = if (leftNum < 0) intervals else intervals.take(leftNum)
    //插入的右部分 不包括重叠
    val rightIntervals = if (leftNum < 0) Nil else {
      val rightIndex = intervals.indexWhere(i => i.start > newInterval.end, from = leftNum)
      if (rightIndex < 0) Nil else intervals.drop(rightIndex)
    }
    //可能有的重叠部分
    val totalSize = intervals.size
    if (leftIntervals.size < totalSize)
      newInterval.start = math.min(newInterval.start, intervals(leftIntervals.size).start)
    if (rightIntervals.size < totalSize)
      newInterval.end = math.max(newInterval.end, intervals(totalSize - rightIntervals.size - 1).end)

    if (leftIntervals.nonEmpty && leftIntervals.last.end >= newInterval.start || rightIntervals.nonEmpty && rightIntervals.head.start <= newInterval.end)
      leftIntervals ++ rightIntervals
    else
      leftIntervals ++ List(newInterval) ++ rightIntervals

  }
}

