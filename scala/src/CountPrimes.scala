import scala.collection.mutable

/** 204. Count Primes
  * Count the number of prime numbers less than a non-negative number, n.
  * Example: Input: 10  Output: 4
  * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
  */
object CountPrimes {
  def countPrimes(n: Int): Int = {
    val x = n - 1
    //静态字段会有多线程问题
    val littleOdds = new mutable.MutableList[Int]
    littleOdds += 2
    for (i <- 3 to 17 by 2) {
      var isOdd = true
      for (odd <- littleOdds if isOdd && odd <= i / 2) {
        if (i % odd == 0)
          isOdd = false
      }
      if (isOdd)
        littleOdds += i
    }


    if (x >= 17) {
      val bigOdds = new mutable.MutableList[Int]
      for (i <- 19 to x by 2) {
        var isOdd = true
        for (odd <- littleOdds if isOdd) {
          if (i % odd == 0)
            isOdd = false
        }
        for (odd <- bigOdds if isOdd && odd <= i / 17) {
          if (i % odd == 0)
            isOdd = false
        }
        if (isOdd) {
          bigOdds += i
        }
      }
      littleOdds.length + bigOdds.length
    } else  {
      littleOdds.indexWhere(_ > x)
    }
  }
}
