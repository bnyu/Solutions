/**
  * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
  * You may assume that the intervals were initially sorted according to their start times.
  * Example 1: Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].
  * Example 2: Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16]. This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
  */
object Solution057 {
  def insert(intervals: List[Interval], newInterval: Interval): List[Interval] = {
    //插入的左部分
    val leftNum = intervals.indexWhere(i => i.end >= newInterval.start)
    val leftIntervals = if (leftNum < 0) {
      intervals
    } else {
      if (leftNum < intervals.size) {
        val left = intervals(leftNum)
        if (left.start < newInterval.start)
          newInterval.start = left.start
      }
      intervals.take(leftNum)
    }
    //插入的右部分
    val rightIndex = if (leftNum < 0) intervals.size else intervals.indexWhere(i => i.start > newInterval.end, from = leftNum)
    val rightIntervals = if (rightIndex < 0) {
      intervals
    } else {
      if (rightIndex > 0) {
        val right = intervals(rightIndex - 1)
        if (right.end > newInterval.end)
          newInterval.end = right.end
      }
      intervals.drop(rightIndex)
    }
    leftIntervals ++ List(newInterval) ++ rightIntervals
  }
}

