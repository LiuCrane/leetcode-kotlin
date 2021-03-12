package stackandqueue

import java.util.*

class ImplementQueueWithStack {
    class MyQueue() {
        private val reverseStack = Stack<Int>()
        private val resStack = Stack<Int>()
        /** Initialize your data structure here. */


        /** Push element x to the back of queue. */
        fun push(x: Int) {
            reverseStack.push(x)
        }

        /** Removes the element from in front of queue and returns that element. */
        fun pop(): Int {
            if (resStack.isNotEmpty()) resStack.clear()
            while (reverseStack.isNotEmpty()) resStack.push(reverseStack.pop())
            val popVal = resStack.pop()
            while (resStack.isNotEmpty())  reverseStack.push(resStack.pop())
            return popVal
        }

        /** Get the front element. */
        fun peek(): Int {
            if (resStack.isNotEmpty()) resStack.clear()
            while (reverseStack.isNotEmpty()) resStack.push(reverseStack.pop())
            val peakVal = resStack.peek()
            while (resStack.isNotEmpty())  reverseStack.push(resStack.pop())
            return peakVal
        }

        /** Returns whether the queue is empty. */
        fun empty(): Boolean = reverseStack.empty()
    }
}