package linkedList

class DeleteDuplicates {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        if (head?.next == null) return head
        if (head.next!!.`val` == head.`val`) {
            head.next = head.next?.next
            deleteDuplicates(head)
        } else deleteDuplicates(head.next)
        return head
    }
}