import scala.collection.{immutable, mutable}

/** 210. Course Schedule II
  * There are a total of n courses you have to take, labeled from 0 to n-1.
  * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
  * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
  * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
  * Example 1:
  * Input: 4, [[1,0],[2,0],[3,1],[3,2]]
  * Output: [0,1,2,3] or [0,2,1,3]
  * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both
  * courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
  * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
  * Note:
  * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
  * You may assume that there are no duplicate edges in the input prerequisites.
  * Hints:
  * This problem is equivalent to finding the topological order in a directed graph. If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
  * Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera explaining the basic concepts of Topological Sort.
  * Topological sort could also be done via BFS.
  */
object CourseScheduleII {

  class Course(val i: Int) {
    var learned = false
  }

  def findOrder(numCourses: Int, prerequisites: Array[Array[Int]]): Array[Int] = {
    val courses = new Array[(Course, mutable.HashSet[Course])](numCourses) //course, pre
    for (i <- 0 until numCourses)
      courses(i) = (new Course(i), new mutable.HashSet[Course])
    //build adjacency list
    for (edge <- prerequisites)
      courses(edge(1))._2 += courses(edge(0))._1

    var canLearn = true //no cycle
    var index = numCourses
    val learned = new Array[Int](numCourses)

    def learn(i: Int, way: immutable.HashSet[Int]): Boolean = {
      val (course, pre) = courses(i)
      if (canLearn && !course.learned) {
        if (!way.contains(i)) {
          val nextWay = way + i
          //only all prerequisites ard learned, this course can learn
          for (p <- pre if canLearn && !p.learned)
            canLearn = learn(p.i, nextWay)
          if (canLearn) {
            course.learned = true
            index -= 1
            learned(index) = course.i
          }
        } else {
          canLearn = false //cycle
        }
      }
      course.learned
    }

    for ((course, _) <- courses if canLearn && !course.learned)
      learn(course.i, new immutable.HashSet[Int])
    if (canLearn)
      learned
    else Array.emptyIntArray
  }

}
