package search

import java.util.*

class PerfectSquares {
    fun numSquares(n: Int): Int {
        val squares = generateSquares(n)
        val queue = LinkedList<Int>()
        val marked = Array(n + 1) {false}
        queue.add(n)
        marked[n] = true
        var level = 0
        while (queue.isNotEmpty()) {
            var size = queue.size
            level ++
            while (size -- > 0) {
                val curNum = queue.poll()
                squares.forEach {
                    val nextNum = curNum - it
                    when {
                        nextNum < 0 -> return@forEach
                        nextNum == 0 -> return level
                        else -> Unit //do nothing
                    }
                    if (!marked[nextNum]) {
                        marked[nextNum] = true
                        queue.add(nextNum)
                    }
                }
            }
        }
        return level
    }

    private fun generateSquares(n: Int): List<Int> {
        val res = mutableListOf<Int>()
        var square = 1
        var diff = 3
        while (square <= n) {
            res.add(square)
            square += diff
            diff +=2
        }
        return res
    }
}