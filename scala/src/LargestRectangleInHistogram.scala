/** 84. Largest Rectangle in Histogram
  * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
  */
object LargestRectangleInHistogram {
  //similar with 11.Container With Most Water
  def largestRectangleArea(heights: Array[Int]): Int = {
    var area = 0
    var preLeftH = 0
    for (i <- heights.indices) {
      val leftH = heights(i)
      if (leftH > preLeftH) {
        preLeftH = leftH
        var rShortest = leftH
        var j = i
        while (j < heights.length && rShortest > 0) {
          val rightH = heights(j)
          if (rightH < rShortest)
            rShortest = rightH
          val side = j - i + 1
          val tempArea = rShortest * side
          area = math.max(tempArea, area)
          j += 1
        }
        preLeftH = 0
      } else if (leftH <= 0)
        preLeftH = 0
    }
    area
  }
}

