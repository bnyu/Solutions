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

    def buyThenSell(index: Int, time: Int, profit: Int): Unit = {
      if (time < maxTime && index < prices.length) {
        var buy = prices(index)
        var get = 0
        for (i <- index + 1 until prices.length) {
          if (prices(i) < buy) {
            buy = prices(i)
          } else if (prices(i) - buy > get) {
            get = prices(i) - buy
            val got = profit + get
            if (got > maxProfit)
              maxProfit = got
            buyThenSell(i + 1, time + 1, got)
          }
        }
      }
    }

    buyThenSell(0, 0, 0)
    maxProfit
  }
}
