class SwapPairs {
    fun swapPairs(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        val second = head.next!!
        val third = head.next!!.next
        second.next = head
        head.next = swapPairs(third)
        return second
    }
}