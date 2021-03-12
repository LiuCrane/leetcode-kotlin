package stackandqueue

import java.util.LinkedList

class ImplementStackWithQueue {
    class MyStack() {

        /** Initialize your data structure here. */
        val queue = LinkedList<Int>()

        /** Push element x onto stack. */
        fun push(x: Int) {
            queue.add(x)
            var size = queue.size
            while (size-- > 1) queue.add(queue.pop())
        }

        /** Removes the element on top of the stack and returns that element. */
        fun pop(): Int = queue.remove()


        /** Get the top element. */
        fun top(): Int = queue.peek()

        /** Returns whether the stack is empty. */
        fun empty(): Boolean = queue.isEmpty()
    }
}