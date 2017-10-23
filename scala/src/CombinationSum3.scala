import scala.collection.mutable

object CombinationSum3 {
  def combinationSum3(k: Int, n: Int): List[List[Int]] = {
    if (n > 45) Nil else {
      val ans = new mutable.MutableList[List[Int]]
      val num = (9 to 1 by -1).map(i => (i, false)).toArray

      def add(x: Int, i: Int): Unit = {
        if (x == n) {
          val l = num.filter(p => p._2)
          if (l.length == k) {
            ans += l.map(p => p._1).reverse.toList
          }
        } else {
          for (j <- i until 9) {
            val (v, _) = num(j)
            val nx = v + x
            if (nx <= n) {
              num(j) = (v, true)
              add(nx, j + 1)
              num(j) = (v, false)
            }
          }
        }
      }

      add(0, 0)
      ans.toList
    }
  }
}
