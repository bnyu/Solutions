import scala.collection.{immutable, mutable}

/** 207. Course Schedule
  * There are a total of n courses you have to take, labeled from 0 to n-1.
  * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
  * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
  * Example 1:  Input: 2, [[1,0]]   Output: true
  * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
  * Example 2:  Input: 2, [[1,0],[0,1]]  Output: false
  * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
  * Note: The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
  * You may assume that there are no duplicate edges in the input prerequisites.
  * Hints: This problem is equivalent to finding if a cycle exists in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
  * Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
  * Topological sort could also be done via BFS.
  */
object CourseSchedule {

  class Course(val i: Int) {
    var learned = false
  }

  def canFinish(numCourses: Int, prerequisites: Array[Array[Int]]): Boolean = {
    val courses = new Array[(Course, mutable.HashSet[Course])](numCourses) //course, pre(or next, it's same)
    for (i <- 0 until numCourses)
      courses(i) = (new Course(i), new mutable.HashSet[Course])
    //build adjacency list
    for (edge <- prerequisites)
      courses(edge(1))._2 += courses(edge(0))._1

    var canLearn = true //no cycle

    def learn(i: Int, way: immutable.HashSet[Int]): Unit = {
      val (course, pre) = courses(i)
      if (canLearn && !course.learned) {
        if (!way.contains(i)) {
          val nextWay = way + i
          var p = pre
          while (canLearn && p.nonEmpty) {
            val c = p.head
            if (!c.learned) {
              learn(c.i, nextWay)
            }
            p = p.tail
          }
          course.learned = true
        } else {
          canLearn = false //cycle
        }
      }
    }

    var i = 0
    while (canLearn && i < numCourses) {
      if (!courses(i)._1.learned) {
        learn(i, new immutable.HashSet[Int])
      }
      i += 1
    }
    canLearn
  }

}

