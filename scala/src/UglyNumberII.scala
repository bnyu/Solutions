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
  private val uglyNumber = {
    var i = 1
    val x = (n: Int) => {
      i *= n
      i
    }
    val n2 = Array.fill(30)(x(2))
    i = 1
    val n3 = Array.fill(19)(x(3))
    i = 1
    val n5 = Array.fill(13)(x(5))

    def multi(array: Seq[Int], array1: Seq[Int], break: Boolean): Seq[Int] = {
      val list = new mutable.MutableList[Int]()
      for (a <- array) {
        var i = 0
        var notOverflow = true
        while ((!break || notOverflow) && i < array1.size) {
          val a1 = array1(i)
          val temp: Long = a.asInstanceOf[Long] * a1
          i += 1
          if (temp > Int.MaxValue)
            notOverflow = false
          else
            list += temp.asInstanceOf[Int]
        }
      }
      list
    }

    val n2x3 = multi(n2, n3, break = true)
    val n2x5 = multi(n2, n5, break = true)
    val n3x5 = multi(n3, n5, break = true)
    val n2x3x5 = multi(n2, n3x5, break = false) //because of n3x5 is out of order

    val uglySet = new mutable.TreeSet[Int]()
    uglySet += 1
    for (n <- n2) uglySet += n
    for (n <- n3) uglySet += n
    for (n <- n5) uglySet += n
    for (n <- n2x3) uglySet += n
    for (n <- n2x5) uglySet += n
    for (n <- n3x5) uglySet += n
    for (n <- n2x3x5) uglySet += n
    uglySet.toArray
  }

  def nthUglyNumber(n: Int): Int = {
    uglyNumber(n - 1)
  }
}
