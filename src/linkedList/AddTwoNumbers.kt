import linkedList.ListNode
import java.util.*

class AddTwoNumbers {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        val stack1 = Stack<Int>()
        val stack2 = Stack<Int>()
        buildStack(stack1, l1)
        buildStack(stack2, l2)
        return getSumNodeList(stack1, stack2)
    }

    private fun getSumNodeList(stack1: Stack<Int>, stack2: Stack<Int>): ListNode? {
        val head = ListNode(-1)
        var carry = 0 // 保存进位
        while (stack1.isNotEmpty() || stack2.isNotEmpty() || carry != 0) {
            val n1 = if (stack1.isEmpty()) 0 else stack1.pop()
            val n2 = if (stack2.isEmpty()) 0 else stack2.pop()
            val sum = n1 + n2 + carry
            val nextNode = head.next
            head.next = ListNode(sum % 10).apply { next = nextNode }
            carry = sum / 10
        }
        return head.next
    }

    private fun buildStack(stack: Stack<Int>, node: ListNode?) {
        if (node != null) {
            stack.push(node.`val`)
            buildStack(stack, node.next)
        }
    }
}