/**
 * 23. Merge k Sorted Lists
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
class Solution023 {

    fun mergeKLists(lists: Array<ListNode?>): ListNode? {
        var node = ListNode(0)
        val preAns = node
        var num = lists.size
        if (num == 0)
            return preAns.next
        else if (num == 1)
            return lists[0]
        // 过滤空的链表 之后空链表只会出现在第一个
        val listNodes = ArrayList<ListNode?>(num)
        for (listNode in lists)
            if (listNode != null)
                listNodes.add(listNode)
        num = listNodes.size
        for (i in 0 until num)
            lists[i] = listNodes[i]

        var start = 0
        val end = num - 1
        // 初次全是乱序 快排
        quickSort(lists, 0, end)
        while (true) {
            if (start > end)
                break
            // 将排好序的链表按表头排序
            insertSort(lists, start, end)
            // 截取出第一个节点
            val listNode = lists[start]
            node.next = listNode
            node = node.next!!
            // 节点往后移 直到全部节点取出 数组往后移
            if (listNode?.next != null)
                lists[start] = listNode.next
            else
                start++
        }
        return preAns.next
    }

    // 仅第一个未排序 用插入排序
    private fun insertSort(listNodes: Array<ListNode?>, start: Int, end: Int) {
        val first = listNodes[start]!!
        var i = start
        while (i < end) {
            val node = listNodes[i + 1]!!
            if (first.`val` <= node.`val`)
                break
            listNodes[i] = listNodes[i + 1]
            i++
        }
        if (i != start)
            listNodes[i] = first
    }

    // 快排
    private fun quickSort(listNodes: Array<ListNode?>, start: Int, end: Int) {
        var i = start
        var j = end
        val mid = listNodes[i]!!
        while (i < j) {
            while (mid.`val` <= listNodes[j]!!.`val` && i < j)
                j--
            if (i < j) {
                listNodes[i] = listNodes[j]
                i++
            }
            while (mid.`val` >= listNodes[i]!!.`val` && i < j)
                i++
            if (i < j) {
                listNodes[j] = listNodes[i]
                j--
            }
            listNodes[i] = mid
        }
        if (i > start)
            quickSort(listNodes, start, i - 1)
        if (i < end)
            quickSort(listNodes, i + 1, end)
    }
}

