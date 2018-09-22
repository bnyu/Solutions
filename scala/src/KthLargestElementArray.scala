import scala.collection.mutable

object KthLargestElementArray {
  def findKthLargest(nums: Array[Int], k: Int): Int = {
    val set = new mutable.TreeSet[Int]()
    var kth = 0
    for (n <- nums) {
      if (set.size < k) {
        if (!set.contains(n)) {
          set.add(n)
          kth = set.head
        }
      } else if (n > kth) {
        if (!set.contains(n)) {
          set.remove(kth)
          set.add(n)
          kth = set.head
        }
      }
    }
    kth
  }
}
