/**
 * 2.Add Two Numbers
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 */
class Solution002 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode {
        var listNode1 = l1
        var listNode2 = l2
        //进位
        var carry = 0
        var addedListNode = ListNode(0)
        val preAns = addedListNode
        while (listNode1 != null || listNode2 != null) {
            val sum: Int
            if (listNode1 != null && listNode2 != null) {
                sum = carry + listNode1.`val` + listNode2.`val`
                listNode1 = listNode1.next
                listNode2 = listNode2.next
            } else if (listNode1 != null) {
                sum = carry + listNode1.`val`
                listNode1 = listNode1.next
            } else {
                //智能转换也不是特别智能...
                sum = carry + (listNode2?.`val` ?: 0)
                listNode2 = listNode2?.next
            }
            val remainder = sum % 10
            carry = sum / 10
            //因为next定义为可空类型 所以不允许直接赋值给非空类型 即使这里已经是一个实例化的ListNode
            addedListNode.next = ListNode(remainder)
            addedListNode = addedListNode.next!!
        }
        if (carry == 1)
            addedListNode.next = ListNode(carry)
        return preAns.next ?: preAns
    }
}

