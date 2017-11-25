import scala.annotation.tailrec
import scala.collection.mutable.ListBuffer

/**
  * 56. Merge Intervals
  * Given a collection of intervals, merge all overlapping intervals.
  * For example, Given [1,3],[2,6],[8,10],[15,18], return [1,6],[8,10],[15,18].
  */
//Definition for an interval:
class Interval(var _start: Int = 0, var _end: Int = 0) {
  var start: Int = _start
  var end: Int = _end
}

object Solution056 {
  def merge(intervals: List[Interval]): List[Interval] = {
    if (intervals.isEmpty)
      intervals
    else
      toMerge(intervals.head, intervals.tail, ListBuffer()).toList
  }

  @tailrec
  def toMerge(x: Interval, list: List[Interval], unique: ListBuffer[Interval]): ListBuffer[Interval] = {
    var overlapping = false
    // 把所有与其重叠的拓展
    for (i <- list) {
      if (i.start <= x.start && i.end >= x.start) {
        i.end = math.max(i.end, x.end)
        overlapping = true
      }
      else if (x.start <= i.start && x.end >= i.start) {
        i.start = math.min(i.start, x.start)
        overlapping = true
      }
    }
    if (!overlapping)
      unique += x
    if (list.nonEmpty)
      toMerge(list.head, list.tail, unique)
    else
      unique
  }

}
