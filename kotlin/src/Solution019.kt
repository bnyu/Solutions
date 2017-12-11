/**
 * 19. Remove Nth Node From End of List
 * Given a linked list, remove the nth node from the end of list and return its head. Given n will always be valid.
 */
class Solution019 {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        val node = head!!
        val map = HashMap<Int, ListNode>()
        var i = 0
        var next: ListNode? = node
        while (next != null) {
            i++
            map.put(i, next)
            next = next.next
        }
        if (n < i) {
            //取出倒数第n个前一个
            val previous = map[i - n]!!
            //删除倒数第n个 使指向第n个的指向n后面那个
            previous.next = map.getOrDefault(i - n + 2, null)
        } else
            return node.next
        return node
    }
}

