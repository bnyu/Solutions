import scala.collection.mutable

/** 218. The Skyline Problem
  * A city's skyline is the outer contour of the silhouette formed by all the buildings in that city when viewed from a distance. Now suppose you are given the locations and height of all the buildings as shown on a cityscape photo (Figure A), write a program to output the skyline formed by these buildings collectively (Figure B).
  * Buildings  Skyline Contour
  * The geometric information of each building is represented by a triplet of integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and right edge of the ith building, respectively, and Hi is its height. It is guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You may assume all buildings are perfect rectangles grounded on an absolutely flat surface at height 0.
  * For instance, the dimensions of all buildings in Figure A are recorded as: [ [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
  * The output is a list of "key points" (red dots in Figure B) in the format of [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key point is the left endpoint of a horizontal line segment. Note that the last key point, where the rightmost building ends, is merely used to mark the termination of the skyline, and always has zero height. Also, the ground in between any two adjacent buildings should be considered part of the skyline contour.
  * For instance, the skyline in Figure B should be represented as:[ [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
  * Notes:
  * The number of buildings in any input list is guaranteed to be in the range [0, 10000].
  * The input list is already sorted in ascending order by the left x position Li.
  * The output list must be sorted by the x position.
  * There must be no consecutive horizontal lines of equal height in the output skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not acceptable; the three lines of height 5 should be merged into one in the final output as such: [...[2 3], [4 5], [12 7], ...]
  */
object TheSkylineProblem {
  def getSkyline(buildings: Array[Array[Int]]): List[Array[Int]] = {
    if (buildings.nonEmpty) {
      val builds = buildings.sortBy(a => a(0))
      val skyline = new mutable.HashMap[Int, Array[Int]]() //key:x, valve:point
      var endX = 0 //skyline end x
      var rightPoints = new mutable.MutableList[Array[Int]] //down stairs points
      for (build <- builds) {
        val li = build(0)
        val ri = build(1)
        val hi = build(2)
        if (skyline.isEmpty || li > endX) { //non cover
          rightPoints.clear()
          var point = Array(endX, 0) //last build end
          if (endX > 0)
            skyline.update(point.head, point)

          point = Array(li, hi)
          rightPoints += point
          skyline.update(point.head, point)

          point = Array(ri, 0) //not add to skyline now
          rightPoints += point
          endX = ri
        } else { //cover
          var loop = true
          var pre = rightPoints.head
          var i = 1
          var changed = false

          var nextRight: mutable.MutableList[Array[Int]] = null
          while (loop && i < rightPoints.length) {
            val right = rightPoints(i)
            val preX = pre(0)
            val preY = pre(1)
            val theX = right(0)
            val theY = right(1)
            var continue = true

            if (!changed && li > preX) {
              if (hi > preY) {
                changed = true
                nextRight = new mutable.MutableList[Array[Int]]
                val point = Array(li, hi) //up: record the higher
                skyline.update(point.head, point)
                nextRight += point
              } else if (ri > theX && hi > theY) {
                changed = true
                continue = false //cause right point is modified already
                nextRight = new mutable.MutableList[Array[Int]]
                if (right(1) == 0)
                  skyline.update(right.head, right)
                right(1) = hi
                nextRight += right
              }
            }

            if (changed && continue) {
              if (ri < theX) {
                if (hi > theY) {
                  // changed already
                  val point = Array(ri, preY) //
                  skyline.update(point.head, point)
                  nextRight += point
                  nextRight ++= rightPoints.drop(i)
                } // else no change
                loop = false
              } else if (hi >= theY) {
                skyline.remove(theX)
              } else {
                changed = true
                right(1) = hi //down: record lower
                nextRight += right
              }
            }

            pre = right
            i += 1
          }

          if (loop) { //ri > pre(0)
            if (nextRight == null)
              nextRight = new mutable.MutableList[Array[Int]]
            val point = Array(ri, 0)
            nextRight += point
          }
          if (changed) {
            rightPoints = nextRight
            endX = rightPoints.last(0)
          }

        }
      }

      val point = Array(endX, 0)
      skyline.update(point.head, point)
      skyline.values.toList.sortBy(a => a.head)
    } else Nil
  }
}

