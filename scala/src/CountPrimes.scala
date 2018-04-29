import scala.collection.mutable

/** 204. Count Primes
  * Count the number of prime numbers less than a non-negative number, n.
  * Example: Input: 10  Output: 4
  * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
  */
object CountPrimes {
  private val odds = new mutable.MutableList[Int]
  odds += 2
  odds += 3
  private var maxOdd = 3
  private var maxN = 4

  def countPrimes(n: Int): Int = {
    val x = n - 1
    if (x > maxN) {
      for (i <- maxN + 1 to x by 2) {
        var isOdd = true
        for (odd <- odds if isOdd && odd <= i / 3) {
          if (i % odd == 0)
            isOdd = false
        }
        if (isOdd) {
          odds += i
          maxOdd = i
        }
      }
      if ((x | 1) == 1)
        maxN = x + 1
      else
        maxN = x
      odds.length
    } else if (x >= maxOdd) {
      odds.length
    } else {
      odds.indexWhere(_ > x)
    }
  }
}
