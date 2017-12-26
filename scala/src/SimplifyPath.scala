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
    var start = 1
    def enterPath(path: String, index: Int): Int = {
      if (path != null && path.nonEmpty) {
        val head = path.head
        val tail = path.tail
        if (head == slash)
          enterPath(tail, index)
        //ok ... 居然是合法路径 多个///忽略为/
        else if (head == dot && tail != null && tail.nonEmpty && tail.head == dot && (tail.tail == null || tail.tail.isEmpty || tail.tail.head == slash))
          enterPath(tail.tail, index - 1)
        else if (head == dot && (tail == null || tail.isEmpty || tail.head == slash))
          enterPath(tail, index)
        else {
          if (index < start) start = index
          val i = path.indexWhere(_ == slash)
          val (head, tail) = if (i > 0) (path.take(i), path.drop(i + 1)) else (path, null)
          paths.update(index, head)
          enterPath(tail, index + 1)
        }
      } else index
    }

    //路径曾到达上级目录 此时以最上层作为初始根目录输出
    val index = enterPath(path, 1)
    var i = start - 1

    def pathStr = {
      i += 1
      paths(i)
    }

    val list = Array.fill(index - start)(pathStr)
    list.mkString("/", "/", "")
  }
}
