/** 135. Candy
  * There are N children standing in a line. Each child is assigned a rating value.
  * You are giving candies to these children subjected to the following requirements:
  * Each child must have at least one candy.
  * Children with a higher rating get more candies than their neighbors.
  * What is the minimum candies you must give?
  * *
  * Example 1:
  * Input: [1,0,2]
  * Output: 5
  * Explanation: You can allocate to the first, second and third child with 2, 1, 2 candies respectively.
  * Example 2:
  * Input: [1,2,2]
  * Output: 4
  * Explanation: You can allocate to the first, second and third child with 1, 2, 1 candies respectively.
  * The third child gets 1 candy because it satisfies the above two conditions.
  */
object Candy {
  def candy(ratings: Array[Int]): Int = {
    val candies = new Array[Int](ratings.length)
    var neighborRate = 0
    var neighborNum = 0
    ratings.indices.foreach(i => {
      candies(i) = if (ratings(i) > neighborRate) neighborNum + 1 else 1
      neighborRate = ratings(i)
      neighborNum = candies(i)
    })
    neighborRate = 0
    neighborNum = 0
    ratings.indices.reverse.foreach(i => {
      candies(i) = if (ratings(i) > neighborRate && candies(i) <= neighborNum) neighborNum + 1 else candies(i)
      neighborRate = ratings(i)
      neighborNum = candies(i)
    })
    candies.sum
  }
}
