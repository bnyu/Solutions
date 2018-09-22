import scala.collection.mutable

object KthLargestElementArray {
  def findKthLargest(nums: Array[Int], k: Int): Int = {
    val map = new mutable.TreeMap[Int, Int]()
    var kth = 0
    var size = 0
    for (n <- nums) {
      if (size < k) {
        map(n) = map.getOrElse(n, 0) + 1
        size += 1
        kth = map.head._1
      } else if (n > kth) {
        val num = map(kth)
        if (num > 1) map(kth) = num - 1 else map.remove(kth)
        map(n) = map.getOrElse(n, 0) + 1
        kth = map.head._1
      }
    }
    kth
  }
}
