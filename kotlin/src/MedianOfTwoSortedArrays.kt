/**
 * 4. Median of Two Sorted Arrays
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 */
class MedianOfTwoSortedArrays {
    fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
        val len1 = nums1.size
        val len2 = nums2.size
        val mid2 = (len1 + len2) / 2
        val mid1 = if ((len1 + len2) % 2 == 0) mid2 - 1 else mid2
        return when {
            len2 != 0 -> {
                var x = 0
                var y = 0
                for (i in 0 until mid1) {
                    when {
                        x >= len1 -> y++
                        y >= len2 -> x++
                        nums1[x] <= nums2[y] -> x++
                        else -> y++
                    }
                }
                //到了第中位数
                val a = when {
                    x < len1 && y < len2 && nums1[x] <= nums2[y] -> nums1[x++]
                    x < len1 && y < len2 -> nums2[y++]
                    x >= len1 -> nums2[y++]
                    else -> nums1[x++]
                }
                val b = when {
                    mid2 == mid1 -> a
                    x < len1 && y < len2 && nums1[x] <= nums2[y] -> nums1[x]
                    x < len1 && y < len2 -> nums2[y]
                    x >= len1 -> nums2[y]
                    else -> nums1[x]
                }
                (a + b).toDouble() / 2
            }
            len1 != 0 -> {
                val a = nums1[mid1]
                val b = nums1[mid2]
                (a + b).toDouble() / 2
            }
            else -> 0.0
        }
    }
}


