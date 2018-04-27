import scala.collection.mutable

/** 188. Best Time to Buy and Sell Stock IV
  * Say you have an array for which the ith element is the price of a given stock on day i.
  * Design an algorithm to find the maximum profit. You may complete at most k transactions.
  * Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
  */
object BestTimeToBuyAndSellStock4 {
  def maxProfit(k: Int, prices: Array[Int]): Int = {
    //similar to 3
    val maxTime = if (k > prices.length / 2) prices.length / 2 else k
    var maxProfit = 0
    val indexAndProfit = new mutable.HashMap[Int, (Int, Int)]() //cache

    def buyThenSell(index: Int, time: Int, profit: Int): Unit = {
      if (time < maxTime && index < prices.length) {
        var buy = prices(index)
        var get = 0
        for (i <- index + 1 until prices.length) {
          if (prices(i) < buy) {
            buy = prices(i)
          } else {
            val temp = prices(i) - buy
            if (temp > get) {
              get = temp
              val got = profit + get
              val oldGot = indexAndProfit.get(time)
              if (oldGot.isEmpty || i < oldGot.get._1 || got > oldGot.get._2) {
                if (got > maxProfit)
                  maxProfit = got
                buyThenSell(i + 1, time + 1, got)
                if (oldGot.isDefined) {
                  val theI = if (oldGot.get._1 < i) i else oldGot.get._1
                  val theGot = if (oldGot.get._2 > got) got else oldGot.get._2
                  indexAndProfit.update(time, (theI, theGot))
                } else {
                  indexAndProfit.update(time, (i, got))
                }
              }
            }
          }
        }
      }
    }

    buyThenSell(0, 0, 0)
    maxProfit
  }
}
