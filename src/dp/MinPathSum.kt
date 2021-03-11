package dp

import kotlin.math.min

class MinPathSum {
    fun minPathSum(grid: Array<IntArray>): Int {
        if (grid.isEmpty()) return 0
        val dp = Array(size = grid.size) { Array(grid[0].size) { 0 } }
        for (row in dp.indices) for (col in dp[row].indices) {
            dp[row][col] = when {
                row == 0 && col == 0 -> 0
                row == 0 -> dp[row][col - 1]
                col == 0 -> dp[row - 1][col]
                else -> min(dp[row - 1][col], dp[row][col - 1])
            }
            dp[row][col] = dp[row][col] + grid[row][col]
        }
        return dp[grid.lastIndex][grid[0].lastIndex]
    }
}