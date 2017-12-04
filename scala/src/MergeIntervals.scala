import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

/**
  * 56. Merge Intervals
  * Given a collection of intervals, merge all overlapping intervals.
  * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
  */

object MergeIntervals {
  def merge(intervals: List[Interval]): List[Interval] = {
    toMerge(intervals, ListBuffer()).toList
  }

  @tailrec
  def toMerge(list: List[Interval], unique: ListBuffer[Interval]): ListBuffer[Interval] = {
    if (list.nonEmpty) {
      val x = list.head
      // 把所有与其重叠的拓展
      var overlapping = false
      for (i <- list.tail) {
        if (x.end >= i.start && x.start <= i.end) {
          i.start = math.min(i.start, x.start)
          i.end = math.max(i.end, x.end)
          overlapping = true
        }
      }
      if (!overlapping)
        unique += x
      toMerge(list.tail, unique)
    } else unique
  }

}

