import scala.collection.mutable

object KthLargestElementArray {
  def findKthLargest(nums: Array[Int], k: Int): Int = {
    //leetcode use scala 2.11.x which mutable.TreeMap not exist
    val set = new mutable.TreeSet[Int]()
    val map = new mutable.HashMap[Int, Int]()
    var kth = 0
    var size = 0
    for (n <- nums) {
      if (size < k) {
        set(n) = true
        map(n) = map.getOrElse(n, 0) + 1
        size += 1
        kth = set.head
      } else if (n > kth) {
        val num = map(kth)
        if (num > 1) {
          map(kth) = num - 1
        } else {
          set.remove(kth)
          map.remove(kth)
        }
        set(n) = true
        map(n) = map.getOrElse(n, 0) + 1
        kth = set.head
      }
    }
    kth
  }
}
