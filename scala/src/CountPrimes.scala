import scala.collection.mutable

/** 204. Count Primes
  * Count the number of prime numbers less than a non-negative number, n.
  * Example: Input: 10  Output: 4
  * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
  */
object CountPrimes {
  def countPrimes(n: Int): Int = {
    val x = n - 1
    if (x > 2) {
      val odds = new mutable.MutableList[Int]
      odds += 2
      for (i <- 3 to x by 2) {
        var isOdd = true
        for (odd <- odds if isOdd && odd <= i / odd) {
          if (i % odd == 0)
            isOdd = false
        }
        if (isOdd) {
          odds += i
        }
      }
      odds.length
    } else if (x == 2) {
      1
    } else 0
  }
}
