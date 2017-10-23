/** 123. Best Time to Buy and Sell Stock III
  * Say you have an array for which the i-th element is the price of a given stock on day i.
  * Design an algorithm to find the maximum profit. You may complete at most two transactions.
  * Note: You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
  */
object BestTimeToBuyAndSellStock3 {
  def maxProfit(prices: Array[Int]): Int = {
    var max = 0
    if (prices.length > 1) {
      var secondBuyIndexAndProfit = (-1, 0) // cache

      def secondBuy(index: Int): Int = {
        if (index <= secondBuyIndexAndProfit._1)
          secondBuyIndexAndProfit._2
        else {
          var profit2 = 0
          var buyAndIndex = (prices(index), index)
          for (i <- index + 1 until prices.length) {
            val sell = prices(i)
            if (sell <= buyAndIndex._1) {
              buyAndIndex = (sell, i)
            } else {
              val profit = sell - buyAndIndex._1
              if (profit > profit2) {
                profit2 = profit
                secondBuyIndexAndProfit = (buyAndIndex._2, profit2)
              }
            }
          }
          profit2
        }
      }

      var profit1 = 0
      var buy = prices.head
      for (i <- prices.indices) {
        val sell = prices(i)
        if (sell <= buy)
          buy = sell
        else {
          val profit = sell - buy
          if (profit > profit1) {
            profit1 = profit
            val profit2 = secondBuy(i)
            val profitCombine = profit1 + profit2
            if (profitCombine > max)
              max = profitCombine
          }
        }
      }

    }
    max
  }
}

