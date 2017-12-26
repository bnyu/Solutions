import scala.collection.mutable

/** 71. Simplify Path
  * Given an absolute path for a file (Unix-style), simplify it.
  * For example, path = "/home/", => "/home"; path = "/a/./b/../../c/", => "/c"
  */
object SimplifyPath {
  def simplifyPath(path: String): String = {
    val slash = '/'
    val dot = '.'
    val paths = mutable.HashMap[Int, String]()

    def enterPath(path: String, index: Int): Int = {
      if (path != null && path.nonEmpty) {
        val c = path.head
        if (c == slash)
          enterPath(path.tail, index)
        else if (c == dot)
          if (path.tail != null && path.tail.head == dot) enterPath(path.tail.tail, index - 1) else enterPath(path.tail, index)
        else {
          val i = path.indexWhere(_ == slash)
          val folder = path.take(i)
          val folders = path.drop(i + 1)
          paths.update(index, folder)
          enterPath(folders, index + 1)
        }
      } else index
    }

    val index = enterPath(path, 0)
    if (index <= 0) {
      ???
    } else {
      ???
    }
  }
}
