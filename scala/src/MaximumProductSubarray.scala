/** 152. Maximum Product Subarray
  * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
  * For example, given the array [2,3,-2,4], the contiguous subarray [2,3] has the largest product = 6.
  */
object MaximumProductSubarray {
  def maxProduct(nums: Array[Int]): Int = {
    if (nums.nonEmpty) {
      var max = nums.head
      var positiveP: Option[Int] = None
      var negativeP: Option[Int] = None

      def multi(nums: Array[Int]): Unit = {
        for (n <- nums) {
          if (n > 0) {
            positiveP = Some(positiveP.getOrElse(1) * n) //正x正
            if (negativeP.isDefined) { //负x正
              negativeP = Some(negativeP.get * n)
            }
          } else if (n < 0) {
            if (negativeP.isDefined) { //若之前乘过负 则负x负 更大
              positiveP = Some(negativeP.get * n)
              negativeP = None
            } else if (positiveP.isDefined) { //遇到第一个负 先记录正再接着x负 等待再次遇见负
              val product = positiveP.get
              if (product > max)
                max = product
              positiveP = None
              negativeP = Some(product * n)
            } else {
              negativeP = Some(n)
            }
          } else { //遇见0 记录 重新开始
            val product = positiveP.getOrElse(0)
            if (product > max)
              max = product
            positiveP = None
            negativeP = None
          }
        }
      }

      multi(nums)
      if (positiveP.isDefined) {
        if (positiveP.get > max)
          max = positiveP.get
      } // 反向再乘一次 因为没有记录从第二个负开始的负值 举个栗子(eg. -2, -3, -4, 5) 正向:6 反向:60
      positiveP = None
      negativeP = None
      multi(nums.reverse)
      max
    } else 0
  }
}

