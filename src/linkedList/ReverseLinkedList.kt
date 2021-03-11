package linkedList

class ReverseLinkedList {
    fun reverseList(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        val next = head.next
        val newHead = reverseList(next)
        next!!.next = head
        head.next = null
        return newHead
    }

    fun reverseList2(head: ListNode?): ListNode? {
        if (head == null) return null
        val helpNode = ListNode(-1)
        var startNode = head
        while (startNode != null) {
            val next = startNode.next
            startNode.next = helpNode.next
            helpNode.next = startNode
            startNode = next
        }
        return helpNode.next
    }
}