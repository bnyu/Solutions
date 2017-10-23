/** 204. Count Primes
  * Count the number of prime numbers less than a non-negative number, n.
  * Example: Input: 10  Output: 4
  * Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
  */
object CountPrimes {
  def countPrimes(n: Int): Int = {
    if (n <= 1) return 0
    val nonPrime = new Array[Boolean](n) //不包括n
    var loop = true
    var x = 2
    while (loop) { //改成while就不会溢出了
      if (x * x > n)
        loop = false
      else {
        if (!nonPrime(x)) { //已经是合数
          for (i <- x + x until n by x) //排除自身
            nonPrime(i) = true //将其倍数设为合数
        }
        x += 1
      }
    }
    nonPrime.count({ b => !b }) - 2 //减去0和1
  }
}
