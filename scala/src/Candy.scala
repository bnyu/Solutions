/** 135. Candy
  * There are N children standing in a line. Each child is assigned a rating value.
  * You are giving candies to these children subjected to the following requirements:
  * - Each child must have at least one candy.
  * - Children with a higher rating get more candies than their neighbors.
  * What is the minimum candies you must give?
  */
object Candy {
  def candy(ratings: Array[Int]): Int = {
    val num = ratings.length
    var lowestIndex = List.empty[Int]
    if (num > 1) {
      var total = 0
      var preIndex = 0
      var down = true
      for (i <- 1 until num) {
        if (down && ratings(i) <= ratings(preIndex) || !down && ratings(i) >= ratings(preIndex)) {
          preIndex = i
        } else {
          if (down)
            lowestIndex = preIndex :: lowestIndex
          down = !down
          preIndex = i
        }
      }
      if (down)
        lowestIndex = preIndex :: lowestIndex
      lowestIndex = lowestIndex.reverse

      var highest = 0
      for (index <- lowestIndex) {
        var candies = 1
        preIndex = index
        for (i <- (highest to index).reverse) {
          if (ratings(i) > ratings(preIndex))
            candies += 1
          preIndex = i
          total += candies
        }
        total -= 1
        var break = false
        candies = 1
        preIndex = index
        for (i <- index until num if !break) {
          if (ratings(i) < ratings(preIndex)) {
            break = true
            highest = i
          } else {
            if (ratings(i) > ratings(preIndex))
              candies += 1
            preIndex = i
            total += candies
          }
        }
      }
      total
    } else num
  }
}

