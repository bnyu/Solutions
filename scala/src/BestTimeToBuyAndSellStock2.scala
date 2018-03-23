/** 122. Best Time to Buy and Sell Stock II
  * Say you have an array for which the ith element is the price of a given stock on day i.
  * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
  */
object BestTimeToBuyAndSellStock2 {
  def maxProfit(prices: Array[Int]): Int = {
    var max = 0
    if (prices.length > 1) {
      var buy = prices.head
      prices.tail.foreach(sell => {
        if (sell <= buy)
          buy = sell
        else {
          max += sell - buy
          buy = sell
        }
      })
    }
    max
  }
}
