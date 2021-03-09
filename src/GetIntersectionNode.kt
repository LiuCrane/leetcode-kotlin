class GetIntersectionNode {
    fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
        var link1 = headA
        var link2 = headB
        while (link1 != link2) {
            link1 = if (link1 == null) headB else link1.next
            link2 = if (link2 == null) headA else link2.next
        }
        return link1
    }
}