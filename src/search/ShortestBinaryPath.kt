package search

import java.util.*

class ShortestBinaryPath {
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        if (grid.isEmpty() || grid[0].isEmpty() || grid[0][0] == 1) return -1 // invalid grid
        val n = grid.lastIndex
        val m = grid[0].lastIndex
        val directions = arrayOf(intArrayOf(1, -1), intArrayOf(1, 0), intArrayOf(1, 1), intArrayOf(0, -1),
        intArrayOf(0, 1), intArrayOf(-1, -1), intArrayOf(-1, 0), intArrayOf(-1, 1)) //eight dirs
        val queue = LinkedList<IntArray>()
        queue.add(intArrayOf(0, 0))
        var pathLength = 0
        while (queue.isNotEmpty()) {
            var size = queue.size
            while (size-- > 0) {
                val curPos = queue.poll()
                val x = curPos[0]
                val y = curPos[1]

                if (x == n && y == m) return pathLength
                directions.forEach {
                    val nextX = x + it[0]
                    val nextY = y + it[1]
                    if (nextX >= 0 && nextY >= 0 && nextX <= n && nextY <= m && grid[nextX][nextY] == 0) {
                        queue.add(intArrayOf(nextX, nextY))
                        grid[nextX][nextY] = 1
                    }
                }
            }
            pathLength++
        }

        return -1
    }
}