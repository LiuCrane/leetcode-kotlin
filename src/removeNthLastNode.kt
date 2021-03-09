class removeNthLastNode {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var last = n
        var fastP : ListNode? = head ?: return null
        while (last-- > 0) fastP = fastP?.next
        if (fastP == null) return head.next
        var slowP : ListNode? = head
        while (fastP!!.next != null) {
            fastP = fastP.next
            slowP = slowP!!.next
        }
        slowP!!.next = slowP.next?.next
        return head
    }
}