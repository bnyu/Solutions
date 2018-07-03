import scala.collection.mutable

/** 264. Ugly Number II
  * Write a program to find the n-th ugly number.
  * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
  * Example:  Input: n = 10  Output: 12
  * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
  * Note:
  * 1 is typically treated as an ugly number.
  * n does not exceed 1690.
  */
object UglyNumberII {
  def nthUglyNumber(n: Int): Int = {
    val uglySet = new mutable.HashSet[Int]()
    uglySet += 1
    val isUgly = (n: Int) => n match {
      case _ if n / 2 * 2 == n => uglySet.contains(n / 2)
      case _ if n / 3 * 3 == n => uglySet.contains(n / 3)
      case _ if n / 5 * 5 == n => uglySet.contains(n / 5)
      case _ => false
    }
    var index = 1
    var num = 1
    var ugly = 1
    while (index < n) {
      num += 1
      if (isUgly(num)) {
        ugly = num
        index += 1
        uglySet += ugly
      }
    }
    ugly
  }
}
